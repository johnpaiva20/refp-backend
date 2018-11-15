package com.tostringtech.refp.core.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity()
@Table(name = "membros_projeto")
public class MembrosProjeto {
	@EmbeddedId
	private MembrosProjetoId codMembrosProjeto;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("codProjeto")
	private Projeto projeto;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("codMembro")
	private Membro membro;

	@Column()
	private String descFuncao;

	@Column()
	private String descTitulacao;

	@Column(length = 1)
	private String snAtivo;

	public MembrosProjeto() {

	}

	public MembrosProjeto(MembrosProjetoId codMembrosProjeto, Projeto projeto, Membro membro, String descFuncao,
			String descTitulacao, String snAtivo) {
		this.codMembrosProjeto = codMembrosProjeto;
		this.projeto = projeto;
		this.membro = membro;
		this.descFuncao = descFuncao;
		this.descTitulacao = descTitulacao;
		this.snAtivo = snAtivo;
	}

	public MembrosProjetoId getCodMembrosProjeto() {
		return codMembrosProjeto;
	}

	public void setCodMembrosProjeto(MembrosProjetoId codMembrosProjeto) {
		this.codMembrosProjeto = codMembrosProjeto;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Membro getMembro() {
		return membro;
	}

	public void setMembro(Membro membro) {
		this.membro = membro;
	}

	public String getDescFuncao() {
		return descFuncao;
	}

	public void setDescFuncao(String descFuncao) {
		this.descFuncao = descFuncao;
	}

	public String getDescTitulacao() {
		return descTitulacao;
	}

	public void setDescTitulacao(String descTitulacao) {
		this.descTitulacao = descTitulacao;
	}

	public String getSnAtivo() {
		return snAtivo;
	}

	public void setSnAtivo(String snAtivo) {
		this.snAtivo = snAtivo;
	}
}
