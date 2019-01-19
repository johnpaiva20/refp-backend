package com.tostringtech.refp.api.controllers;

import com.tostringtech.refp.api.resources.*;
import com.tostringtech.refp.core.entities.Recurso;
import com.tostringtech.refp.core.services.ProjetoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/projects")
@Api(tags = "Project", description = "Endpoints de Projeto")
public class ProjetoController {

    private static final Logger logger = Logger.getLogger(ProjetoController.class);

    @Autowired
    private ProjetoService projetoService;


    //@PostMapping("/{codProjeto}/enterprises")
    public ResponseEntity<ProjectEnterpriseResource> addEnterprise(@PathVariable Long codProjeto, @RequestBody EnterpriseResource resource) {
        projetoService.addEnterprise(codProjeto, resource);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //@PostMapping("/{codProjeto}/resource")
    public ResponseEntity<?> addResource(@PathVariable Long codProjeto, Recurso recurso) {
        // TODO Auto-generated method stub
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("")
    @ApiOperation(value = "Cadastrar um novo Projeto ")
    public ResponseEntity<ProjectResource> create(ProjectResource projetoResource) {
        ProjectResource resource = projetoService.create(projetoResource);
        if (resource != null) {
            return new ResponseEntity<>(resource, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{codProjeto}")
    @ApiOperation(value = "Deletar um Projeto")
    public ResponseEntity<?> delete(@PathVariable Long codProjeto) {
        projetoService.delete(codProjeto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("")
    @ApiOperation(value = "Encontrar todos os Projetos cadastrados")
    public ResponseEntity<List<ProjectResource>> findAll() {
        List<ProjectResource> allprojects = projetoService.findAll();
        if (!allprojects.isEmpty()) {
            return new ResponseEntity<>(allprojects, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // @GetMapping("/{codProjeto}/expenses")
    public ResponseEntity<?> findAllExpenses(@PathVariable Long codProjeto) {
        // TODO Auto-generated method stub
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/inovation-phases")
    @ApiOperation(value = "Lista todas as fases de inovação")
    public ResponseEntity<List<InovationPhaseResource>> findAllInovationPhases() {
        List<InovationPhaseResource> allProjectInovationPhases = projetoService.findAllProjectInovationPhases();
        if (!allProjectInovationPhases.isEmpty()) {
            return new ResponseEntity<>(allProjectInovationPhases, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //@GetMapping("/{codProjeto}/members")
    public ResponseEntity<?> findAllMembers(@PathVariable Long codProjeto) {
        // TODO Auto-generated method stub
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/product-types")
    @ApiOperation(value = "Lista todos os produtos")
    public ResponseEntity<List<ProductTypeResource>> findAllProductTypes() {
        List<ProductTypeResource> allProjectProductsTypes = projetoService.findAllProjectProductsTypes();
        if (!allProjectProductsTypes.isEmpty()) {
            return new ResponseEntity<>(allProjectProductsTypes, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{codProjeto}/enterprises")
    public ResponseEntity<List<ProjectEnterpriseResource>> findAllProjectEnterprises(@PathVariable Long codProjeto) {

        List<ProjectEnterpriseResource> allProjectEnterprises = projetoService.findAllProjectEnterprises(codProjeto);

        if (!allProjectEnterprises.isEmpty()) {
            return new ResponseEntity<>(allProjectEnterprises, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/types")
    @ApiOperation(value = "Lista todos os tipos de Projeto")
    public ResponseEntity<List<ProjectTypeResource>> findAllProjectTypes() {
        List<ProjectTypeResource> allProjectTypes = projetoService.findAllProjectTypes();
        if (!allProjectTypes.isEmpty()) {
            return new ResponseEntity<>(allProjectTypes, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //@GetMapping("/{codProjeto}/resources")
    public ResponseEntity<?> findAllResources(@PathVariable Long codProjeto) {
        // TODO Auto-generated method stub
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/segments")
    @ApiOperation(value = "Lista todos os segmentos")
    public ResponseEntity<List<SegmentResource>> findAllSegments() {
        List<SegmentResource> allProjectSegments = projetoService.findAllProjectSegments();
        if (!allProjectSegments.isEmpty()) {
            return new ResponseEntity<>(allProjectSegments, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // @GetMapping("/subjects/{codTema}/sub-subjects")
    @ApiOperation(value = "Lista todos os subtemas para Projeto")
    public ResponseEntity<?> findAllSubSubjects(@PathVariable String codTema) {
        // TODO Auto-generated method stub
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // @GetMapping("/subjects")
    @ApiOperation(value = "Lista todos os temas para Projeto")
    public ResponseEntity<?> findAllSubjects() {
        // TODO Auto-generated method stub
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{codProjeto}")
    @ApiOperation(value = "Encontrar um Projeto ")
    public ResponseEntity<ProjectResource> findById(@PathVariable Long codProjeto) {

        ProjectResource projeto = projetoService.buildProjectResource(codProjeto);
        if (projeto != null) {
            return new ResponseEntity<>(projeto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //@GetMapping("/{codProjeto}/enterprises/{codEmpresa}")
    public ResponseEntity<ProjectEnterpriseResource> findProjectEnterprise(@PathVariable Long codProjeto, @PathVariable Long codEmpresa) {
        //TODO
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // @PutMapping("/{codProjeto}")
    @ApiOperation(value = "Atualizar um Projeto")
    public ResponseEntity<ProjectResource> update(@PathVariable Long codProjeto, @RequestBody ProjectResource projeto) {
        // TODO Auto-generated method stub
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
