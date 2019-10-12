package com.tostringtech.refp.projeto.api.rest.controller;

import com.tostringtech.refp.application.models.EmpPro;
import com.tostringtech.refp.application.models.Projeto;
import com.tostringtech.refp.application.models.TipoProjeto;
import com.tostringtech.refp.categoria_contabil.api.service.CategoriaContabilService;
import com.tostringtech.refp.empresa.api.services.EmpresaService;
import com.tostringtech.refp.projeto.api.rest.resources.*;
import com.tostringtech.refp.projeto.api.service.ProjetoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController()
@Api(tags = "Projects")
public class ProjectController {

    private static final Logger logger = Logger.getLogger(ProjectController.class);

    @Autowired
    private ProjetoService projetoService;

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private CategoriaContabilService categoriaContabilService;

    @PostMapping("/projects")
    @ApiOperation(tags = {"Projects"}, value = "Cadastrar um novo Projeto ")
    public ResponseEntity<ProjectResource> createProject(@RequestBody ProjectResource resource) {
        Projeto projeto = projetoService.create(new Projeto(resource));
        resource = new ProjectResource(projeto);
        return new ResponseEntity<>(resource, HttpStatus.CREATED);
    }

    @GetMapping("/projects")
    @ApiOperation(tags = {"Projects"}, value = "Encontrar todos os Projetos cadastrados")
    public ResponseEntity<List<ProjectResource>> listAllProjects(Pageable pageable) {

        List<ProjectResource> resources = projetoService
                .findAll(pageable)
                .stream()
                .map(ProjectResource::new)
                .collect(Collectors.toList());

        if (!resources.isEmpty()) {
            return new ResponseEntity<>(resources, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/projects/{id}")
    @ApiOperation(tags = {"Projects"}, value = "Encontrar Projeto")
    public ResponseEntity<ProjectResource> findProjectById(@PathVariable Long id) {
        Projeto projeto = projetoService.findById(id).orElse(null);
        ProjectResource resource = new ProjectResource(projeto);

        if (resource != null) {
            return new ResponseEntity<>(resource, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/projects/{id}")
    @ApiOperation(tags = {"Projects"}, value = "Atualizar Projeto")
    public ResponseEntity<Void> updateProject(@RequestBody ProjectResource resoruce, @PathVariable Long id) {
        Projeto projeto = new Projeto();
        projeto.setCodigo(id);
        projeto = projetoService.update(projeto);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/types")
    @ApiOperation(tags = {"Projects"}, value = "Listar os tipos de projeto")
    public ResponseEntity<List<ProjectTypeResource>> listAllProjectTypes() {
        List<ProjectTypeResource> resources = new ArrayList<>();

        List<TipoProjeto> tipos = projetoService.listAllProjectTypes();
        for (TipoProjeto tipo : tipos) {
            resources.add(new ProjectTypeResource(tipo));
        }

        if (!resources.isEmpty()) {
            return ResponseEntity.ok().body(resources);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/projects/{projectId}/enterprises")
    @ApiOperation(tags = {"Projects", "Enterprises"}, value = "Encontrar Empresas do Projeto")
    public ResponseEntity<List<ProjectEnterpriseResource>> listProjectEnterprises(@PathVariable Long projectId) {
        List<ProjectEnterpriseResource> empresas = this.empresaService.listAllProjectEnterprises(projectId).stream().map(ProjectEnterpriseResource::new).collect(Collectors.toList());
        if (!empresas.isEmpty()) {
            return ResponseEntity.ok(empresas);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/projects/{projectId}/enterprises")
    @ApiOperation(tags = {"Projects", "Enterprises"}, value = "Adicionar Empresas do Projeto")
    public ResponseEntity<List<ProjectEnterpriseResource>> addProjectEnterprises(@PathVariable Long projectId, @RequestBody List<ProjectEnterpriseResource> enterprises) {
        List<EmpPro> empresas = enterprises.stream().map(EmpPro::new).collect(Collectors.toList());
        this.empresaService.addProjectEnterprises(empresas, projectId);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "projects/products/types")
    @ApiOperation(tags = {"Product"}, value = "Listar tipos de produto")
    public ResponseEntity<List<ProductTypeResource>> listAllProductsTypes() {
        List<ProductTypeResource> resources = projetoService
                .listProductTypes()
                .stream()
                .map(ProductTypeResource::new)
                .collect(Collectors.toList());

        if (!resources.isEmpty()) {
            return ResponseEntity.ok().body(resources);
        }
        return ResponseEntity.noContent().build();
    }

    /*@GetMapping(value = "/projects/page")
    @ApiOperation(tags = {"Project"}, value = "Encontrar Projeto")
    public ResponseEntity<Page<ProjectResource>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "descricaoRecurso") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        Page<Projeto> list = projetoService.findPage(page, linesPerPage, orderBy, direction);
        Page<ProjectResource> listDto = list.map(ProjectResource::new);
        return ResponseEntity.ok().body(listDto);
    }*/
    /*@GetMapping(value = "/segments")
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
    }*/
    /*@GetMapping(value = "/innovation-phases")
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
    }*/

}
