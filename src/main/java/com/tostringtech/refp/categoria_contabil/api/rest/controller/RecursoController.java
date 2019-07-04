package com.tostringtech.refp.categoria_contabil.api.rest.controller;

import com.tostringtech.refp.application.model.Recurso;
import com.tostringtech.refp.categoria_contabil.api.rest.resources.AssetResource;
import com.tostringtech.refp.categoria_contabil.api.service.RecursoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@Api(tags = {"Asset"})
public class RecursoController {

    @Autowired
    private RecursoService recursoService;

    @GetMapping(value = "/assets/{id}")
    @ApiOperation(tags = {"Asset"}, value = "Buscar um recurso")
    public ResponseEntity<AssetResource> findById(@PathVariable Long id) {
        Recurso rec = recursoService.findByCod(id);
        AssetResource resource = new AssetResource(rec);
        return ResponseEntity.ok().body(resource);
    }
/*
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<AssetResource>> findAll() {
        List<Recurso> list = recursoService.findAll();
        List<AssetResource> listDto = list.stream().map(rec -> new AssetResource(rec)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }
}*/

    @GetMapping(value = "/assets/page")
    @ApiOperation(tags = {"Asset"}, value = "Listar recursos")
    public ResponseEntity<Page<AssetResource>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "descricaoRecurso") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        Page<Recurso> list = recursoService.findPage(page, linesPerPage, orderBy, direction);
        Page<AssetResource> listDto = list.map(rec -> new AssetResource(rec));
        return ResponseEntity.ok().body(listDto);
    }


    @PostMapping("/assets")
    @ApiOperation(tags = {"Asset"}, value = "Cadastrar um novo Recurso ")
    public ResponseEntity<Void> create(@RequestBody AssetResource resource) {
        Recurso recurso = recursoService.create(new Recurso(resource));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").build(recurso.getCodigo());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/assets/{id}")
    @ApiOperation(tags = {"Asset"}, value = "Alterar um Recurso ")
    public ResponseEntity<Void> update(@RequestBody Recurso recurso, @PathVariable Long id) {
        recurso.setCodigo(id);
        recurso = recursoService.update(recurso);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/assets/{id}")
    @ApiOperation(tags = {"Asset"}, value = "Deletar um Recurso ")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        recursoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
