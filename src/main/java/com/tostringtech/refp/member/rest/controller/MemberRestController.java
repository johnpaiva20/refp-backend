package com.tostringtech.refp.member.rest.controller;

import com.tostringtech.refp.member.api.resources.MemberResource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = {"Member"})
public class MemberRestController {

    @PostMapping("/members")
    @ApiOperation(tags = {"Member"}, value = "Cadastrar um novo membro")
    public ResponseEntity<MemberResource> createMember(@RequestBody MemberResource resource) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
