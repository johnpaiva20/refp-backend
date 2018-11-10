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
	Long codProjeto;
	@Column(nullable = false, unique = true)
	String cdAneel;
	@Column(nullable = false)
	String dsTitulo;
	@Column(nullable = false)
	Calendar dtInicio;
	@Column(nullable = false)
	int vlDuracaoMeses;
	@Column(nullable = false, unique = true)
	String dsOrdemServico;
	@Column(nullable = false)
	String status;
	
	@OneToMany(targetEntity=Membro.class)
	Set<Membro>membros;
	
	@OneToMany()
	List<Despesa>despesas;

	
	
	
	
	
	public Long getCdProjeto() {
		return codProjeto;
	}

	public void setCdProjeto(Long cdProjeto) {
		this.codProjeto = cdProjeto;
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

}
