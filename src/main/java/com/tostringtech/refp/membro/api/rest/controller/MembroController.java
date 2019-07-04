package com.tostringtech.refp.membro.api.rest.controller;


import com.tostringtech.refp.application.model.Projeto;
import com.tostringtech.refp.membro.api.rest.resources.MemberResource;
import com.tostringtech.refp.projeto.api.rest.resources.ProjectResource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/members")
@Api(tags = "Member", description = "Endpoints de membros")
public class MembroController {

    @PostMapping("")
    @ApiOperation(tags = {"Member"},value = "Cadastrar um novo membro")
    public ResponseEntity<MemberResource> createMember(@RequestBody MemberResource resource) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
