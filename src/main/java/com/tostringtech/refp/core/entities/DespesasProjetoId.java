package com.tostringtech.refp.core.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DespesasProjetoId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "cod_projeto")
	private Long codProjeto;

	@Column(name = "cod_despesa")
	private Long codDespesa;

	public DespesasProjetoId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DespesasProjetoId(Long codProjeto, Long codDespesa) {
		super();
		this.codProjeto = codProjeto;
		this.codDespesa = codDespesa;
	}

	public Long getCodProjeto() {
		return codProjeto;
	}

	public void setCodProjeto(Long codProjeto) {
		this.codProjeto = codProjeto;
	}

	public Long getCodDespesa() {
		return codDespesa;
	}

	public void setCodDespesa(Long codDespesa) {
		this.codDespesa = codDespesa;
	}

}
