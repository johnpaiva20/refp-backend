package com.tostringtech.refp.core.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(value="Projeto")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Projeto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4639376019630777524L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(hidden = true)
	private Long codProjeto;

	
	@Column(nullable = false, unique = true)
	@ApiModelProperty()
	private String cdAneel;

	@Column(nullable = false)
	@ApiModelProperty()
	private String dsTitulo;

	@Column(nullable = false)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@ApiModelProperty()
	private Date dtInicio;

	@Column(nullable = false)
	@ApiModelProperty()
	private int vlDuracaoMeses;

	@Column(nullable = false, unique = true)
	@ApiModelProperty()
	private String dsOrdemServico;

	@Column(nullable = false)
	@ApiModelProperty()
	private String status;

	@OneToMany(targetEntity = Membro.class)
	@ApiModelProperty(hidden = true)
	@RestResource(exported = false)
    @JsonIgnore
	private Set<Membro> membros=new HashSet<>();

	@OneToMany(targetEntity = Despesa.class)
	@ApiModelProperty(hidden = true)
	@JsonIgnore
	private List<Despesa> despesas=new ArrayList<>();

	@OneToMany(targetEntity = Empresa.class)
	@ApiModelProperty(hidden = true)
	    @JsonIgnore
	private Set<Empresa> empresas=new HashSet<>();

	public Projeto() {

	}

	public Projeto(Long codProjeto, String cdAneel, String dsTitulo, Date dtInicio, int vlDuracaoMeses,
			String dsOrdemServico, String status) {
		this.codProjeto = codProjeto;
		this.cdAneel = cdAneel;
		this.dsTitulo = dsTitulo;
		this.dtInicio = dtInicio;
		this.vlDuracaoMeses = vlDuracaoMeses;
		this.dsOrdemServico = dsOrdemServico;
		this.status = status;
	}

	public Long getCodProjeto() {
		return codProjeto;
	}

	public String getCdAneel() {
		return cdAneel;
	}

	public void setCdAneel(String cdAneel) {
		this.cdAneel = cdAneel;
	}

	public String getDsTitulo() {
		return dsTitulo;
	}

	public void setDsTitulo(String dsTitulo) {
		this.dsTitulo = dsTitulo;
	}

	public Date getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}

	public int getVlDuracaoMeses() {
		return vlDuracaoMeses;
	}

	public void setVlDuracaoMeses(int vlDuracaoMeses) {
		this.vlDuracaoMeses = vlDuracaoMeses;
	}

	public String getDsOrdemServico() {
		return dsOrdemServico;
	}

	public void setDsOrdemServico(String dsOrdemServico) {
		this.dsOrdemServico = dsOrdemServico;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<Membro> getMembros() {
		return membros;
	}

	public void setMembros(Set<Membro> membros) {
		this.membros = membros;
	}

	public List<Despesa> getDespesas() {
		return despesas;
	}

	public void setDespesas(List<Despesa> despesas) {
		this.despesas = despesas;
	}

	public Set<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(Set<Empresa> empresas) {
		this.empresas = empresas;
	}

}
