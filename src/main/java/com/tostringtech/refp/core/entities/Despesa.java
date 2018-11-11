package com.tostringtech.refp.core.entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Despesa {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long codDespesa;
	@Column
	String nrDocumento;
	@Column
	double vlDespesa;
	@Column
	Calendar dtDespesa;
}
