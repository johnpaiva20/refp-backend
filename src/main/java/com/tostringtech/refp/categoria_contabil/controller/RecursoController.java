package com.tostringtech.refp.categoria_contabil.controller;

import com.tostringtech.refp.application.model.Recurso;
import com.tostringtech.refp.categoria_contabil.controller.resources.AssetResource;
import com.tostringtech.refp.categoria_contabil.service.RecursoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/assets")
@Api(tags = "Recurso")
public class RecursoController {


    @Autowired
    private RecursoService recursoService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
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

    /*@RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResponseEntity<Page<AssetResource>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "descricaoRecurso") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        Page<Recurso> list = recursoService.findPage(page, linesPerPage, orderBy, direction);
        Page<AssetResource> listDto = list.map(rec -> new AssetResource(rec));
        return ResponseEntity.ok().body(listDto);
    }
*/

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody AssetResource resource) {
        Recurso recurso = recursoService.create(new Recurso(resource));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").build(recurso.getCodigo());
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Recurso recurso, @PathVariable Long id) {
        recurso.setCodigo(id);
        recurso = recursoService.update(recurso);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        recursoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
