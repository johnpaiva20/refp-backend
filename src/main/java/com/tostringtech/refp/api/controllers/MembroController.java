package com.tostringtech.refp.api.controllers;

import com.tostringtech.refp.api.resources.MemberResource;
import com.tostringtech.refp.core.services.MembroService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/members")
@Api(tags = "Membro")
public class MembroController {

    @Autowired
    private MembroService membroService;

    //@PostMapping("")
    ResponseEntity<MemberResource> create(@Valid @RequestBody MemberResource membro) {
        //TODO
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //@DeleteMapping("")
    ResponseEntity<?> delete(Long codMembro) {
        //TODO
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //@GetMapping("")
    ResponseEntity<List<MemberResource>> findAll() {
        //TODO
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //@GetMapping("/{codMembro}")
    ResponseEntity<MemberResource> findById(@PathVariable Long codMembro) {
        //TODO
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //@PutMapping("/{codMembro}")
    ResponseEntity<MemberResource> update(@PathVariable Long codMembro, @Valid @RequestBody MemberResource membro) {
        //TODO
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}