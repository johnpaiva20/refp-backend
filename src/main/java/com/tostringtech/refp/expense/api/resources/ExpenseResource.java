package com.tostringtech.refp.expense.api.resources;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tostringtech.refp.application.models.Despesa;
import com.tostringtech.refp.application.models.Projeto;
import com.tostringtech.refp.expense.api.enums.DocumentType;
import com.tostringtech.refp.expense.api.enums.ExpenseType;
import com.tostringtech.refp.project.api.resources.ProjectResource;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "Expense")
public class ExpenseResource {
	
	private Long id;
	
	private String documentNumber;
	
	private String recipient;
	
	private String cpfCnpj;
	
	private DocumentType documentType;
	
	private String justify;
	
	private double value;
	
	private Date data;
	
	private ExpenseType expenseType;
	
	private Projeto projResource;	
	
    public ExpenseResource() {
    }
    
    public ExpenseResource(Despesa despesa) {
    	this.setId(despesa.getCodigo());
    	this.setDocumentNumber(despesa.getNumeroDocumento());
    	this.setRecipient(despesa.getBeneficiario());
    	this.setCpfCnpj(despesa.getCpfCnpj());
    	this.setDocumentType(DocumentType.getDocumentType(despesa.getTipoDocumento()));
    	this.setJustify(despesa.getJustificativa());
    	this.setValue(despesa.getValor());
    	this.setData(despesa.getData());
    	this.setExpenseType(ExpenseType.getExpenseType(despesa.getTipoRubrica()));
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

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

	public String getJustify() {
		return justify;
	}

	public void setJustify(String justify) {
		this.justify = justify;
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

	public ExpenseType getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(ExpenseType expenseType) {
		this.expenseType = expenseType;
	}

	public Projeto getProjResource() {
		return projResource;
	}

	public void setProjResource(Projeto projResource) {
		this.projResource = projResource;
	}
        
}
