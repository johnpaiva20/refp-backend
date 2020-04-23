<<<<<<< HEAD
package com.tostringtech.refp.expense.api.resources;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tostringtech.refp.application.models.Despesa;
import com.tostringtech.refp.application.models.Projeto;
import com.tostringtech.refp.project.api.resources.ProjectResource;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "Expense")
public class ExpenseResource {
	
	private Long id;
	
	private String documentNumber;
	
	private double value;
	
	private Date data;
	
	@JsonIgnore
	private Projeto projResource;
	
    public ExpenseResource() {
    }
    
    public ExpenseResource(Despesa despesa) {
    	this.setId(despesa.getCodigo());
    	this.setDocumentNumber(despesa.getNumeroDocumento());
    	this.setValue(despesa.getValor());
    	this.setData(despesa.getData());
    	this.setProjResource(despesa.getProjeto());
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Projeto getProjResource() {
		return projResource;
	}

	public void setProjResource(Projeto projResource) {
		this.projResource = projResource;
	}
    
    
}
=======
package com.tostringtech.refp.expense.api.resources;

import com.tostringtech.refp.application.models.Despesa;

public class ExpenseResource {
    public ExpenseResource(Despesa despesa) {

    }
}
>>>>>>> 65bf307dfdf65769f165a97dda841d4e2cc34860
