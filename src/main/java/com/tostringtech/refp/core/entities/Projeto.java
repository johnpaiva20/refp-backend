package com.tostringtech.refp.core.entities;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Projeto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codProjeto;
	@Column(nullable = false, unique = true)
	private String cdAneel;
	@Column(nullable = false)
	private String dsTitulo;
	@Column(nullable = false)
	private Calendar dtInicio;
	@Column(nullable = false)
	private int vlDuracaoMeses;
	@Column(nullable = false, unique = true)
	private String dsOrdemServico;
	@Column(nullable = false)
	private String status;
	
	@OneToMany(targetEntity=Membro.class)
	private Set<Membro>membros;
	
	@OneToMany()
	private List<Despesa>despesas;
	
	@OneToMany()
	private Set<Empresa>empresas;

	public Long getCodProjeto() {
		return codProjeto;
	}

	public void setCodProjeto(Long codProjeto) {
		this.codProjeto = codProjeto;
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

	public Calendar getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(Calendar dtInicio) {
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
