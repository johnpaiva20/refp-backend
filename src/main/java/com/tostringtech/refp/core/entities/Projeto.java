package com.tostringtech.refp.core.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(value = "Projeto")
public class Projeto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(hidden = true)
	private Long codProjeto;

	@Column(nullable = false, unique = true)
	@ApiModelProperty()
	private String codAneel;

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

	@ApiModelProperty()
	@Column
	private String tpProjeto;

	@Column(nullable = false)
	@ApiModelProperty()
	private String status;

	@JsonIgnore
	@ApiModelProperty(hidden = true)
	@OneToMany(mappedBy = "membro", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<MembrosProjeto> membrosProjeto = new HashSet<>();

	@JsonIgnore
	@ApiModelProperty(hidden = true)
	@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<EmpresasProjeto> empresasProjeto = new HashSet<>();

	@JsonIgnore
	@ApiModelProperty(hidden = true)
	@OneToMany(mappedBy = "despesa", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DespesasProjeto> despesasProjeto = new ArrayList<>();

	@JsonIgnore
	@ApiModelProperty(hidden = true)
	@OneToMany(mappedBy = "recurso", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RecursoProjeto> recursosProjeto = new ArrayList<RecursoProjeto>();

	
	public Projeto() {

	}

	public Projeto(Long codProjeto, String cdAneel, String dsTitulo, Date dtInicio, int vlDuracaoMeses,
			String dsOrdemServico, String status) {
		this.codProjeto = codProjeto;
		this.codAneel = cdAneel;
		this.dsTitulo = dsTitulo;
		this.dtInicio = dtInicio;
		this.vlDuracaoMeses = vlDuracaoMeses;
		this.dsOrdemServico = dsOrdemServico;
		this.status = status;
	}

	public Long getCodProjeto() {
		return codProjeto;
	}

	public void setCodProjeto(Long codProjeto) {
		this.codProjeto = codProjeto;
	}

	public String getCodAneel() {
		return codAneel;
	}

	public void setCodAneel(String codAneel) {
		this.codAneel = codAneel;
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

	public Set<MembrosProjeto> getMembrosProjeto() {
		return membrosProjeto;
	}

	public void setMembrosProjeto(Set<MembrosProjeto> membrosProjeto) {
		this.membrosProjeto = membrosProjeto;
	}

	public Set<EmpresasProjeto> getEmpresasProjeto() {
		return empresasProjeto;
	}

	public void setEmpresasProjeto(Set<EmpresasProjeto> empresasProjeto) {
		this.empresasProjeto = empresasProjeto;
	}

	public List<DespesasProjeto> getDespesasProjeto() {
		return despesasProjeto;
	}

	public void setDespesasProjeto(List<DespesasProjeto> despesasProjeto) {
		this.despesasProjeto = despesasProjeto;
	}

	public List<RecursoProjeto> getRecursosProjeto() {
		return recursosProjeto;
	}

	public void setRecursosProjeto(List<RecursoProjeto> recursosProjeto) {
		this.recursosProjeto = recursosProjeto;
	}

	public String getTpProjeto() {
		return tpProjeto;
	}

	public void setTpProjeto(String tpProjeto) {
		this.tpProjeto = tpProjeto;
	}
}
