package com.tostringtech.refp.projeto.api.rest.controller;

import com.tostringtech.refp.projeto.api.rest.filters.ProjectTypeFilter;
import com.tostringtech.refp.projeto.api.rest.resources.SubtopicResource;
import com.tostringtech.refp.projeto.api.rest.resources.TopicResource;
import com.tostringtech.refp.projeto.api.service.ProjetoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController()
@Api(tags = {"Topics"})
public class TopicController {

    @Autowired
    private ProjetoService projetoService;

    @GetMapping(value = "/topics")
    @ApiOperation(tags = {"Topics"}, value = "Listar temas")
    public ResponseEntity<List<TopicResource>> listAllTopicsByProjectType(ProjectTypeFilter filter) {
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

    @GetMapping(value = "/subtopics-{topic}")
    @ApiOperation(tags = {"Topics"}, value = "Listar subtemas")
    public ResponseEntity<List<SubtopicResource>> listAllSubtopicsByTopic(@PathVariable String topic) {
        List<SubtopicResource> resources = projetoService.findAllSubtopicsByTopic(topic).stream().map(SubtopicResource::new).collect(Collectors.toList());

        if (!resources.isEmpty()) {
            return ResponseEntity.ok().body(resources);
        }
        return ResponseEntity.noContent().build();
    }
}

