package com.tostringtech.refp.projeto.controller;

import com.tostringtech.refp.application.domain.FaseInovacao;
import com.tostringtech.refp.application.domain.Produto;
import com.tostringtech.refp.application.domain.SegmentoSetorEletrico;
import com.tostringtech.refp.application.domain.TipoProjeto;
import com.tostringtech.refp.application.model.CategoriaContabil;
import com.tostringtech.refp.application.model.Projeto;
import com.tostringtech.refp.categoria_contabil.service.CategoriaContabilService;
import com.tostringtech.refp.projeto.controller.resources.*;
import com.tostringtech.refp.projeto.service.ProjetoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/projects")
@Api(tags = "Projeto", description = "Endpoints de Projeto")
public class ProjetoController {

    private static final Logger logger = Logger.getLogger(ProjetoController.class);

    @Autowired
    private ProjetoService projetoService;

    @Autowired
    private CategoriaContabilService categoriaContabilService;

    @PostMapping("")
    @ApiOperation(value = "Cadastrar um novo Projeto ")
    public ResponseEntity<ProjectResource> create(@RequestBody ProjectResource resource) {
        Projeto projeto = projetoService.create(new Projeto(resource));
        resource = new ProjectResource(projeto);
        if (resource != null) {
            return new ResponseEntity<>(resource, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("")
    @ApiOperation(value = "Encontrar todos os Projetos cadastrados")
    public ResponseEntity<List<ProjectResource>> findAll() {

        List<ProjectResource> resources = projetoService
                .findAll()
                .stream()
                .map(ProjectResource::new)
                .collect(Collectors.toList());

        if (!resources.isEmpty()) {
            return new ResponseEntity<>(resources, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Encontrar Projeto")
    public ResponseEntity<ProjectResource> findById(@PathVariable Long id) {
        Projeto projeto = projetoService.findById(id).orElse(null);
        ProjectResource resource = new ProjectResource(projeto);

        if (resource != null) {
            return new ResponseEntity<>(resource, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResponseEntity<Page<ProjectResource>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "descricaoRecurso") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        Page<Projeto> list = projetoService.findPage(page, linesPerPage, orderBy, direction);
        Page<ProjectResource> listDto = list.map(ProjectResource::new);
        return ResponseEntity.ok().body(listDto);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody ProjectResource resoruce, @PathVariable Long id) {
        Projeto projeto = new Projeto();

        projeto.setCodigo(id);
        projeto = projetoService.update(projeto);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/account-categories-{type}")
    public ResponseEntity<List<AccountCategoryResource>> findAllAccountCategoriesByProjectType(@PathVariable String type) {

        List<AccountCategoryResource> categoriasContabeis = categoriaContabilService
                .findAllByProjectType(type)
                .stream()
                .map(AccountCategoryResource::new)
                .collect(Collectors.toList());

        if (!categoriasContabeis.isEmpty()) {
            return ResponseEntity.ok().body(categoriasContabeis);
        }
        return ResponseEntity.noContent().build();
    }


    @GetMapping(value = "/segments")
    public ResponseEntity<List<SegmentResource>> findAllSegments() {
        List<SegmentResource> resources = new ArrayList<>();


        for (SegmentoSetorEletrico segmentosSetorEletrico : SegmentoSetorEletrico.values()) {
            resources.add(new SegmentResource(segmentosSetorEletrico.getCodigo(), segmentosSetorEletrico.getSegmento()));
        }


        if (!resources.isEmpty()) {
            return ResponseEntity.ok().body(resources);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/topics-{type}")
    public ResponseEntity<List<TopicResource>> findAllTopicsByProjectType(@PathVariable String type) {
        List<TopicResource> resources = projetoService
                .findAllTopicsByProjectType(type)
                .stream()
                .map(TopicResource::new)
                .collect(Collectors.toList());

        if (!resources.isEmpty()) {
            return ResponseEntity.ok().body(resources);
        }

        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/subtopics-{topic}")
    public ResponseEntity<List<SubtopicResource>> findAllSubtopicsByTopic(@PathVariable String topic) {
        List<SubtopicResource> resources = projetoService.findAllSubtopicsByTopic(topic).stream().map(SubtopicResource::new).collect(Collectors.toList());

        if (!resources.isEmpty()) {
            return ResponseEntity.ok().body(resources);
        }

        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/products")
    public ResponseEntity<List<ProductResource>> findAllProducts() {
        List<ProductResource> resources = new ArrayList<>();

        for (Produto produto : Produto.values()) {
            resources.add(new ProductResource(produto.getCodigo(), produto.getProduto()));
        }

        if (!resources.isEmpty()) {
            return ResponseEntity.ok().body(resources);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/innovation-phases")
    public ResponseEntity<List<InnovationPhase>> findAllInnovationPhases() {
        List<InnovationPhase> resources = new ArrayList<>();

        for (FaseInovacao fase : FaseInovacao.values()) {
            resources.add(new InnovationPhase(fase.getCodigo(), fase.getFase()));
        }

        if (!resources.isEmpty()) {
            return ResponseEntity.ok().body(resources);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/types")
    public ResponseEntity<List<ProjectTypeResource>> findAllTypes() {
        List<ProjectTypeResource> resources = new ArrayList<>();

        for (TipoProjeto tipo : TipoProjeto.values()) {
            resources.add(new ProjectTypeResource(tipo.getCodigo(), tipo.getTipo()));
        }

        if (!resources.isEmpty()) {
            return ResponseEntity.ok().body(resources);
        }
        return ResponseEntity.noContent().build();
    }


}
