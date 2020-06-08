package com.tostringtech.refp.expense.rest.controller;

import com.tostringtech.refp.application.exceptions.ObjectNotFoundException;
import com.tostringtech.refp.application.models.Despesa;
import com.tostringtech.refp.expense.api.repository.ExpenseRepository;
import com.tostringtech.refp.expense.api.resources.ExpenseResource;
import com.tostringtech.refp.expense.api.service.ExpenseService;
//import com.tostringtech.refp.reports.ReportService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.jboss.logging.Logger;
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

    private static final Logger logger = Logger.getLogger(ExpenseRestController.class);

    @Autowired
    private ExpenseService expenseService;
    
    @Autowired
    private ExpenseRepository repo;
    
//    @Autowired
//    private ReportService reportService;

    @PostMapping("/expenses")
    @ApiOperation(tags = {"Expense"}, value = "Cadastrar uma nova Despesa ")
    public ResponseEntity<ExpenseResource> createExpense(@RequestBody ExpenseResource resource) {
        Despesa despesa = expenseService.create(new Despesa(resource));
        resource = new ExpenseResource(despesa);
        return new ResponseEntity<>(resource, HttpStatus.CREATED);
    }

    @GetMapping("/expenses")
    @ApiOperation(tags = {"Expense"}, value = "Listar despesas cadastradas")
    public ResponseEntity<List<ExpenseResource>> listExpenses(Pageable pageable) {

        List<ExpenseResource> resources = expenseService
                .findAll(pageable)
                .stream()
                .map(ExpenseResource::new)
                .collect(Collectors.toList());

        if (!resources.isEmpty()) {
        	return ResponseEntity.ok(resources);
        }
        return (ResponseEntity<List<ExpenseResource>>) ResponseEntity.noContent();
    }

    @GetMapping("/expenses/{id}")
    @ApiOperation(tags = {"Expense"}, value = "Encontrar uma Despesas")
    public ResponseEntity<ExpenseResource> findExpenseById(@PathVariable Long id) {
        Despesa despesa = expenseService.findById(id).orElse(null);
        if (despesa != null) {
        	ExpenseResource resource = new ExpenseResource(despesa);
        	return ResponseEntity.ok(resource);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @PutMapping(value = "/expenses/{id}")
    @ApiOperation(tags = {"Expense"}, value = "Atualizar uma Despesa")
    public ResponseEntity<Despesa> updateExpense(@RequestBody ExpenseResource resource, @PathVariable Long id){
    	Despesa despesa = expenseService.findById(id).orElseThrow(() -> {
            return new ObjectNotFoundException("Despesa não encontrada");
        });
    	if(resource.getData() != null) {
    		despesa.setData(resource.getData());
    	}
    	if (resource.getValue() != 0D) {
    		despesa.setValor(resource.getValue());;
    	}
    	if(resource.getDocumentNumber() != null) {
    		despesa.setNumeroDocumento(resource.getDocumentNumber());    		
    	}
        if(resource.getNomeBeneficiado() != null) {
            despesa.setNomeBeneficiado(resource.getNomeBeneficiado());
        }
        if(resource.getInscricaoBeneficiado() != null) {
            despesa.setInscricaoBeneficado(resource.getInscricaoBeneficiado());
        }
        if(resource.getJustificativaDespesa() != null) {
            despesa.setJustificativaDespesa(resource.getJustificativaDespesa());
        }

    	despesa = expenseService.update(despesa);
    	return ResponseEntity.noContent().build();
    }


    @DeleteMapping(value = "/expenses/{id}")
    @ApiOperation(tags = {"Expense"}, value = "Deletar uma Despesa")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
    	expenseService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
//    @GetMapping(value = "/expenses/report/")
//    public String generateExpenseReport(Pageable pageable) throws FileNotFoundException, JRException{
//    	return reportService.exportReport(pageable);
//    }
}
