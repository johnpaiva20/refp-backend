package com.tostringtech.refp.core.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EmpresasProjetoId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "cod_projeto")
	private Long codProjeto;

	@Column(name = "cod_empresa")
	private Long codEmpresa;

	public EmpresasProjetoId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmpresasProjetoId(Long codProjeto, Long codEmpresa) {
		super();
		this.codProjeto = codProjeto;
		this.codEmpresa = codEmpresa;
	}

	public Long getCodProjeto() {
		return codProjeto;
	}

	public void setCodProjeto(Long codProjeto) {
		this.codProjeto = codProjeto;
	}

	public Long getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(Long codEmpresa) {
		this.codEmpresa = codEmpresa;
	}
}
