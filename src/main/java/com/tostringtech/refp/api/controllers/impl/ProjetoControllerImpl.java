package com.tostringtech.refp.api.controllers.impl;

import com.tostringtech.refp.api.controllers.ProjetoController;
import com.tostringtech.refp.core.entities.*;
import com.tostringtech.refp.core.services.ProjetoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController(value = "Projetos")
@RequestMapping(value = "/projetos")
@Api(tags = "Projeto")
public class ProjetoControllerImpl implements ProjetoController {

    private static final Logger logger = Logger.getLogger(ProjetoControllerImpl.class);

    @Autowired
    private ProjetoService projetoService;

    // Projeto
    @Override
    @GetMapping(value = "")
    public ResponseEntity<?> findAll() throws Exception {
        logger.info("Finding all Projects");
        List<Projeto> projetos = projetoService.findAll();
        return ResponseEntity.ok().body(projetos);
    }

    @Override
    @PostMapping(value = "")
    public ResponseEntity<Projeto> create(@Valid @RequestBody(required = true) Projeto projeto) {
        Projeto p = projetoService.create(projeto);
        return ResponseEntity.ok().body(p);
    }

    @Override
    @PutMapping(value = "")
    public ResponseEntity<?> update(@RequestBody() Projeto projeto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @DeleteMapping(value = "/{codProjeto}")
    public ResponseEntity<?> delete(@PathVariable Long codProjeto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @GetMapping(value = "/{codProjeto}")
    public ResponseEntity<?> findById(@PathVariable Long codProjeto) {
        Projeto p = projetoService.findByCod(codProjeto);
        return ResponseEntity.ok().body(p);
    }

    @Override
    @GetMapping(value = "/{codProjeto}/members")
    public ResponseEntity<?> findAllMembers(Long codProjeto) {
        List<Membro> allProjectMembers = projetoService.findAllProjectMembers(codProjeto);
        return ResponseEntity.ok().body(allProjectMembers);
    }

    @Override
    @GetMapping(value = "/{codProjeto}/expenses")
    public ResponseEntity<?> findAllExpenses(Long codProjeto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @GetMapping(value = "/{codProjeto}/enterprises")
    public ResponseEntity<?> findAllEnterprises(Long codProjeto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @GetMapping(value = "/{codProjeto}/resources")
    public ResponseEntity<?> findAllResources(@PathVariable Long codProjeto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @PostMapping(value = "/{codProjeto}/resources")
    public ResponseEntity<?> addResource(@PathVariable Long codProjeto, @RequestBody Recurso recurso) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @GetMapping(value = "/types")
    public ResponseEntity<?> findAllTypes() {
        List<TipoProjeto> allProjectTypes = projetoService.findAllProjectTypes();
        return ResponseEntity.ok().body(allProjectTypes);
    }

    @Override
    @GetMapping(value = "/subjects")
    public ResponseEntity<?> findAllSubjects() {
        List<TemaProjeto> allProjectSubjects = projetoService.findAllProjectSubjects();
        return ResponseEntity.ok().body(allProjectSubjects);
    }

    @Override
    @GetMapping(value = "/subjects/{codTema}/sub-subjects")
    public ResponseEntity<?> findAllSubSubjects(@PathVariable String codTema) {
        List<SubtemaProjeto> allProjectSubSubjects = projetoService.findAllProjectSubSubjects(codTema);
        return ResponseEntity.ok().body(allProjectSubSubjects);
    }


    @Override
    @GetMapping(value = "/segments")
    public ResponseEntity<?> findAllSegments() {
        List<SegmentoProjeto> segmentos = projetoService.findAllProjectSegments();
        return ResponseEntity.ok().body(segmentos);
    }

    @Override
    @GetMapping(value = "/inovation-phases")
    public ResponseEntity<?> findAllInovationPhases() {
        List<FaseCadeiaInovacaoProjeto> fasesInovacao = projetoService.findAllProjectInovationPhases();
        return ResponseEntity.ok().body(fasesInovacao);
    }

    @Override
    @GetMapping(value = "/product-types")
    public ResponseEntity<?> findAllProductTypes() {
        List<TipoProduto> allProjectProductsTypes = projetoService.findAllProjectProductsTypes();
        return ResponseEntity.ok().body(allProjectProductsTypes);
    }
}
