package com.tostringtech.refp.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TemaProjeto {

	@Id
	private String codTema;
	@Column
	private String descTema;
	
	//private Set<SubtemaProjeto> subtemas;

}
