package com.tostringtech.refp.projeto.api.rest.controller;

import com.tostringtech.refp.application.models.Subtema;
import com.tostringtech.refp.projeto.api.rest.filters.TopicFilter;
import com.tostringtech.refp.projeto.api.rest.resources.SubtopicResource;
import com.tostringtech.refp.projeto.api.rest.resources.TopicResource;
import com.tostringtech.refp.projeto.api.service.ProjetoService;
import com.tostringtech.refp.projeto.api.service.TemaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController()
@Api(tags = {"Topics"})
public class TopicController {

    @Autowired
    private ProjetoService projetoService;

    @Autowired
    private TemaService temaService;

    @GetMapping(value = "/topics")
    @ApiOperation(tags = {"Topics"}, value = "Listar temas")
    public ResponseEntity<List<TopicResource>> listAllTopicsByProjectType(TopicFilter filter) {
        List<TopicResource> resources = projetoService
                .findAllTopicsByProjectType(filter)
                .stream()
                .map(TopicResource::new)
                .collect(Collectors.toList());

        if (!resources.isEmpty()) {
            return ResponseEntity.ok().body(resources);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/subtopics")
    @ApiOperation(tags = {"Topics"}, value = "Listar subtemas")
    public ResponseEntity<List<SubtopicResource>> listAllSubtopicsByTopic(String topic) {
        List<SubtopicResource> resources = projetoService.findAllSubtopicsByTopic(topic).stream().map(SubtopicResource::new).collect(Collectors.toList());

        if (!resources.isEmpty()) {
            return ResponseEntity.ok().body(resources);
        }
        return ResponseEntity.noContent().build();
    }


    @PostMapping("/subtopics")
    @ApiOperation(tags = {"Topics"}, value = "Criar subtemas")
    public ResponseEntity<Void> insert(Subtema obj) {
        obj = temaService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getCodigo()).toUri();
        return ResponseEntity.created(uri).build();
    }
}

