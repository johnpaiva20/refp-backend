package com.tostringtech.refp.core.entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

@Entity
public class Projeto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long cdProjeto;
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

	public Long getCdProjeto() {
		return cdProjeto;
	}

	public void setCdProjeto(Long cdProjeto) {
		this.cdProjeto = cdProjeto;
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
