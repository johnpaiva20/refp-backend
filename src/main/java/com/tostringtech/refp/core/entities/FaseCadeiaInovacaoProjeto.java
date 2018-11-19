package com.tostringtech.refp.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class FaseCadeiaInovacaoProjeto {
	@Id
	private String codFaseCadeia;
	@Column
	private String descFaseCadeia;
}
