package com.tostringtech.refp.application.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tostringtech.refp.expense.api.resources.ExpenseResource;

@Entity
@Table(name = "DESPESA")
public class Despesa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_DESPESA")
    private Long codigo;

    @Column(name = "NR_DOCUMENTO")
    private String numeroDocumento;
    
    @Column(name = "BENEFICIARIO")
    private String beneficiario;
    
    @Column(name = "CPF_CNPJ")
    private String cpfCnpj;
    
    @Column(name = "TIPO_DOCUMENTO")
    private String tipoDocumento;
    
    @Column(name = "JST_DESPESA")
    private String justificativa;
    
    @Column(name = "RB_DESPESA")
    private String tipoRubrica;

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
    	this.setBeneficiario(resource.getRecipient());
    	this.setCpfCnpj(resource.getCpfCnpj());
    	this.setTipoDocumento(resource.getDocumentType().getTipo());
    	this.setJustificativa(resource.getJustify());
    	this.setTipoRubrica(resource.getExpenseType().getTipo());
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

	public String getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(String beneficiario) {
		this.beneficiario = beneficiario;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getTipoRubrica() {
		return tipoRubrica;
	}

	public void setTipoRubrica(String tipoRubrica) {
		this.tipoRubrica = tipoRubrica;
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




