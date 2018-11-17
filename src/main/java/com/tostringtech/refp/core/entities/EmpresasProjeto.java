package com.tostringtech.refp.core.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity()
@Table(name = "empresas_projeto")
public class EmpresasProjeto {

	@EmbeddedId
	private EmpresasProjetoId codEmpresasProjeto;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("codProjeto")
	private Projeto projeto;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("codEmpresa")
	private Empresa empresa;
	
	@Column
	private String tpEmpresa;

	public EmpresasProjeto() {
		super();
	}

	public EmpresasProjeto(EmpresasProjetoId codEmpresasProjeto, Projeto projeto, Empresa empresa) {
		super();
		this.codEmpresasProjeto = codEmpresasProjeto;
		this.projeto = projeto;
		this.empresa = empresa;
	}

	public EmpresasProjetoId getCodEmpresasProjeto() {
		return codEmpresasProjeto;
	}

	public void setCodEmpresasProjeto(EmpresasProjetoId codEmpresasProjeto) {
		this.codEmpresasProjeto = codEmpresasProjeto;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getTpEmpresa() {
		return tpEmpresa;
	}

	public void setTpEmpresa(String tpEmpresa) {
		this.tpEmpresa = tpEmpresa;
	}

}
