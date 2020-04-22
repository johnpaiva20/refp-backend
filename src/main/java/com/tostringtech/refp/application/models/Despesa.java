package com.tostringtech.refp.application.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tostringtech.refp.expense.api.resources.ExpenseResource;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "DESPESA")
public class Despesa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_DESPESA")
    private Long codigo;

    @Column(name = "NR_DOCUMENTO")
    private String numeroDocumento;

    @Column(name = "VL_DESPESA")
    private double valor;

    @Column(name = "DT_DESPESA")
    private Date data;

    @JsonIgnoreProperties({"despesas"})
    @ManyToOne
    @JoinColumn(name = "COD_PROJETO", foreignKey = @ForeignKey(name = "DESPESA_PROJETO_FK"))
    private Projeto projeto;

    public Despesa() {

    }

    public Despesa(ExpenseResource resource) {
    	this.setCodigo(resource.getId());
    	this.setNumeroDocumento(resource.getDocumentNumber());
    	this.setValor(resource.getValue());
    	this.setData(resource.getData());
    	this.setProjeto(resource.getProjResource());
    }

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
    
    
}




