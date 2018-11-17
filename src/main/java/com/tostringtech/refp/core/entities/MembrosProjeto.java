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

	@ManyToOne
	@MapsId("codFuncaoMembro")
	private FuncaoMembro descFuncao;

	@ManyToOne
	@MapsId("codTitulacaoMembro")
	private TitulacaoMembro descTitulacao;

	@Column(length = 1)
	private String snAtivo;

	public MembrosProjeto() {

	}

}
