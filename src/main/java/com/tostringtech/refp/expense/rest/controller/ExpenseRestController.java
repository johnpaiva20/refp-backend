package com.tostringtech.refp.expense.rest.controller;

import com.tostringtech.refp.application.models.Despesa;
import com.tostringtech.refp.application.models.Projeto;
import com.tostringtech.refp.enterprise.api.resources.EnterpriseResource;
import com.tostringtech.refp.expense.api.resources.ExpenseResource;
import com.tostringtech.refp.expense.api.service.ExpenseService;
import com.tostringtech.refp.project.api.resources.ProjectResource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Api(tags = "Expense")
public class ExpenseRestController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping("/expenses")
    @ApiOperation(tags = {"Expense"}, value = "Cadastrar uma nova Despesa ")
    public ResponseEntity<ExpenseResource> createProject(@RequestBody ExpenseResource resource) {
        Despesa despesa = expenseService.create(new Despesa(resource));
        resource = new ExpenseResource(despesa);
        return new ResponseEntity<>(resource, HttpStatus.CREATED);
    }

    @GetMapping("/expenses")
    @ApiOperation(tags = {"Expense"}, value = "Listar despesas cadastradas")
    public ResponseEntity<List<ExpenseResource>> listProjects(Pageable pageable) {

        List<ExpenseResource> resources = expenseService
                .findAll()
                .stream()
                .map(ExpenseResource::new)
                .collect(Collectors.toList());

        if (!resources.isEmpty()) {
            return new ResponseEntity<>(resources, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/expenses/{id}")
    @ApiOperation(tags = {"Expense"}, value = "Encontrar uma Despesas")
    public ResponseEntity<ExpenseResource> findProjectById(@PathVariable Long id) {
        Despesa despesa = expenseService.findById(id).orElse(null);
        ExpenseResource resource = new ExpenseResource(despesa);

        if (resource != null) {
            return new ResponseEntity<>(resource, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/expenses/{id}")
    @ApiOperation(tags = {"Expense"}, value = "Atualizar uma Despesa")
    public ResponseEntity<Void> updateProject(@RequestBody ProjectResource resoruce, @PathVariable Long id) {
        //TODO
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/expenses/{id}")
    @ApiOperation(tags = {"Expense"}, value = "Deletar uma Despesa")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        //TODO
        return ResponseEntity.noContent().build();
    }
}
