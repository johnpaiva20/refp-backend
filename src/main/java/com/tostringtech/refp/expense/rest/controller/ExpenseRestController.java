package com.tostringtech.refp.expense.rest.controller;

import com.tostringtech.refp.application.exceptions.ObjectNotFoundException;
import com.tostringtech.refp.application.models.Despesa;
import com.tostringtech.refp.aws.service.S3Service;
import com.tostringtech.refp.expense.api.repository.ExpenseRepository;
import com.tostringtech.refp.expense.api.resources.ExpenseResource;
import com.tostringtech.refp.expense.api.service.ExpenseService;
//import com.tostringtech.refp.reports.ReportService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.apache.commons.io.FileUtils;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@Api(tags = "Expense")
public class ExpenseRestController {

    private static final Logger logger = Logger.getLogger(ExpenseRestController.class);

    @Autowired
    private ExpenseService expenseService;
    
    @Autowired
    private S3Service s3;
    
    private final String PATH = "src\\main\\resources\\image.png";

    @PostMapping("/expenses")
    @ApiOperation(tags = {"Expense"}, value = "Cadastrar uma nova Despesa ")
    public ResponseEntity<ExpenseResource> createExpense(@RequestBody ExpenseResource resource) {
    	if (resource.getImage() != null && !resource.getImage().equals("")) {    		
    		resource.setImage(resource.getImage().split("base64,")[1]);
    		String image = decoder(resource.getImage(), PATH);
    		String imageId = new Date().toString().replace(" ", "");
    		s3.uploadFile(image, imageId);
    		File file = new File("src\\main\\resources\\image.png");
    		boolean isFileDeleted = FileUtils.deleteQuietly(file);
    		resource.setImage("https://refp.s3-sa-east-1.amazonaws.com/" + imageId + ".jpg");
    	} else {
    		resource.setImage("");
    	}
        Despesa despesa = expenseService.create(new Despesa(resource));
        resource = new ExpenseResource(despesa);
        return new ResponseEntity<>(resource, HttpStatus.CREATED);
    }

    @GetMapping("/expenses")
    @ApiOperation(tags = {"Expense"}, value = "Listar despesas cadastradas")
    public ResponseEntity<List<ExpenseResource>> listExpenses(Pageable pageable) {

    	List<ExpenseResource> resources = expenseService.
    			findAll()
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
    	despesa = expenseService.update(new Despesa(resource));
    	return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/expenses/{id}")
    @ApiOperation(tags = {"Expense"}, value = "Deletar uma Despesa")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
    	expenseService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    private String decoder(String base64Image, String pathFile) {
	    try (FileOutputStream imageOutFile = new FileOutputStream(pathFile)) {
	      // Converting a Base64 String into Image byte array
	      byte[] imageByteArray = Base64.getDecoder().decode(base64Image);
	      imageOutFile.write(imageByteArray);
	      return pathFile;
	    } catch (FileNotFoundException e) {
	      System.out.println("Image not found" + e);
	    } catch (IOException ioe) {
	      System.out.println("Exception while reading the Image " + ioe);
	    }
	    return null;
    }
    
}
