package com.tostringtech.refp.projeto.api.rest.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tostringtech.refp.application.model.Subtema;
import com.tostringtech.refp.projeto.api.rest.resources.SubtopicResource;
import com.tostringtech.refp.projeto.api.service.SubtemaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "Subtopics")
public class SubtemaController {
	
	@Autowired
	SubtemaService subtemaService;

	@GetMapping(value = "/subtopics")
    @ApiOperation(tags = {"SubTopics"}, value = "Listar Subtemas")
	public ResponseEntity<List<SubtopicResource>> listAll(){
		List<SubtopicResource> resources = subtemaService.
				findAll()
				.stream()
				.map(SubtopicResource::new)
				.collect(Collectors.toList());
		
		if(!resources.isEmpty())
			return ResponseEntity.ok().build();
		
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	@ApiOperation(tags = {"SubTopics"}, value = "Criar subtemas")
	public ResponseEntity<Void> insert(Subtema obj){
		obj = subtemaService.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getCodigo()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
