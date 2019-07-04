package com.tostringtech.refp.projeto.api.rest.controller;

import com.tostringtech.refp.application.model.*;
import com.tostringtech.refp.categoria_contabil.api.service.CategoriaContabilService;
import com.tostringtech.refp.empresa.api.services.EmpresaService;
import com.tostringtech.refp.projeto.api.rest.resources.*;
import com.tostringtech.refp.projeto.api.service.ProjetoService;
import io.swagger.annotations.ApiOperation;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProjetoController {

    private static final Logger logger = Logger.getLogger(ProjetoController.class);

    @Autowired
    private ProjetoService projetoService;

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private CategoriaContabilService categoriaContabilService;

    @PostMapping("/projects")
    @ApiOperation(tags = {"Project"}, value = "Cadastrar um novo Projeto ")
    public ResponseEntity<ProjectResource> createProject(@RequestBody ProjectResource resource) {
        Projeto projeto = projetoService.create(new Projeto(resource));
        resource = new ProjectResource(projeto);
        if (resource != null) {
            return new ResponseEntity<>(resource, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/projects")
    @ApiOperation(tags = {"Project"}, value = "Encontrar todos os Projetos cadastrados")
    public ResponseEntity<List<ProjectResource>> listAllProjects(Pageable pageable) {

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

    @GetMapping("/projects/{id}")
    @ApiOperation(tags = {"Project"}, value = "Encontrar Projeto")
    public ResponseEntity<ProjectResource> findProjectById(@PathVariable Long id) {
        Projeto projeto = projetoService.findById(id).orElse(null);
        ProjectResource resource = new ProjectResource(projeto);

        if (resource != null) {
            return new ResponseEntity<>(resource, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @RequestMapping(value = "/projects/page", method = RequestMethod.GET)
    @ApiOperation(tags = {"Project"}, value = "Encontrar Projeto")
    public ResponseEntity<Page<ProjectResource>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "descricaoRecurso") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        Page<Projeto> list = projetoService.findPage(page, linesPerPage, orderBy, direction);
        Page<ProjectResource> listDto = list.map(ProjectResource::new);
        return ResponseEntity.ok().body(listDto);
    }


    @RequestMapping(value = "/projects/{id}", method = RequestMethod.PUT)
    @ApiOperation(tags = {"Project"}, value = "Atualizar Projeto")
    public ResponseEntity<Void> updateProject(@RequestBody ProjectResource resoruce, @PathVariable Long id) {
        Projeto projeto = new Projeto();

        projeto.setCodigo(id);
        projeto = projetoService.update(projeto);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/account-categories-{type}")
    @ApiOperation(tags = {"Account"}, value = "Listar categorias contabeis")
    public ResponseEntity<List<AccountCategoryResource>> listAllAccountCategoriesByProjectType(@PathVariable String type) {

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
    @ApiOperation(tags = {"Segment"}, value = "Listar segmentos do setor eletrico")
    public ResponseEntity<List<SegmentResource>> listAllProjectSegments() {
        List<SegmentResource> resources = new ArrayList<>();

        List<Segmento> segmentos = projetoService.listAllSegments();
        for (Segmento segmento : segmentos) {
            resources.add(new SegmentResource(segmento));
        }

        if (!resources.isEmpty()) {
            return ResponseEntity.ok().body(resources);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/topics-{type}")
    @ApiOperation(tags = {"Topic"}, value = "Listar temas")
    public ResponseEntity<List<TopicResource>> listAllTopicsByProjectType(@PathVariable String type) {
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
    @ApiOperation(tags = {"Subtopic"}, value = "Listar subtemas")
    public ResponseEntity<List<SubtopicResource>> listAllSubtopicsByTopic(@PathVariable String topic) {
        List<SubtopicResource> resources = projetoService.findAllSubtopicsByTopic(topic).stream().map(SubtopicResource::new).collect(Collectors.toList());

        if (!resources.isEmpty()) {
            return ResponseEntity.ok().body(resources);
        }

        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/products-types")
    @ApiOperation(tags = {"Product"}, value = "Listar tipos de produto")
    public ResponseEntity<List<ProductResource>> listAllProductsTypes() {
        List<ProductResource> resources = new ArrayList<>();

        List<Produto> produtos = this.projetoService.listAllProductsTypes();
        for (Produto produto : produtos) {
            resources.add(new ProductResource(produto));
        }

        if (!resources.isEmpty()) {
            return ResponseEntity.ok().body(resources);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/innovation-phases")
    @ApiOperation(tags = {"Innovation Phase"}, value = "Listar fases de inovação")
    public ResponseEntity<List<InnovationPhaseResource>> listAllInnovationPhases() {
        List<InnovationPhaseResource> resources = new ArrayList<>();

        List<FaseInova> fasesInovacao = this.projetoService.listAllInnovationPhases();

        for (FaseInova fase : fasesInovacao) {
            resources.add(new InnovationPhaseResource(fase));
        }

        if (!resources.isEmpty()) {
            return ResponseEntity.ok().body(resources);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/types")
    @ApiOperation(tags = {"Project"}, value = "Listar os tipos de projeto")
    public ResponseEntity<List<ProjectTypeResource>> listAllProjectTypes() {
        List<ProjectTypeResource> resources = new ArrayList<>();

        List<TipPro> tipos = projetoService.listAllProjectTypes();
        for (TipPro tipo : tipos) {
            resources.add(new ProjectTypeResource(tipo));
        }

        if (!resources.isEmpty()) {
            return ResponseEntity.ok().body(resources);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/projects/{projectId}/enterprises")
    @ApiOperation(tags = {"Enterprise"}, value = "Encontrar Empresas do Projeto")
    public ResponseEntity<List<ProjectEnterpriseResource>> listProjectEnterprises(@PathVariable Long projectId) {
        List<ProjectEnterpriseResource> empresas = this.empresaService.listAllProjectEnterprises(projectId).stream().map(ProjectEnterpriseResource::new).collect(Collectors.toList());
        if (!empresas.isEmpty()) {
            return ResponseEntity.ok(empresas);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/projects/{projectId}/enterprises")
    @ApiOperation(tags = {"Enterprise"}, value = "Adicionar Empresas do Projeto")
    public ResponseEntity<List<ProjectEnterpriseResource>> addProjectEnterprises(@PathVariable Long projectId, @RequestBody List<ProjectEnterpriseResource> enterprises) {
        List<EmpPro> empresas = enterprises.stream().map(EmpPro::new).collect(Collectors.toList());
        this.empresaService.addProjectEnterprises(empresas, projectId);
        return ResponseEntity.ok().build();
    }
}
