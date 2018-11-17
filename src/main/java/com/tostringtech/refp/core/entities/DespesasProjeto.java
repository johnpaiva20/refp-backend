package com.tostringtech.refp.core.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity()
@Table(name = "despesas_projeto")
public class DespesasProjeto {

	@EmbeddedId
	private DespesasProjetoId codDespesasProjeto;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("codProjeto")
	private Projeto projeto;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("codDespesa")
	private Despesa despesa;

	public DespesasProjeto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DespesasProjeto(DespesasProjetoId codDespesassProjeto, Projeto projeto, Despesa despesa) {
		super();
		this.codDespesasProjeto = codDespesassProjeto;
		this.projeto = projeto;
		this.despesa = despesa;
	}

	public DespesasProjetoId getCodDespesassProjeto() {
		return codDespesasProjeto;
	}

	public void setCodDespesassProjeto(DespesasProjetoId codDespesassProjeto) {
		this.codDespesasProjeto = codDespesassProjeto;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Despesa getDespesa() {
		return despesa;
	}

	public void setDespesa(Despesa despesa) {
		this.despesa = despesa;
	}

}
