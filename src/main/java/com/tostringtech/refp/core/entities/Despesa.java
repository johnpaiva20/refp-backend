package com.tostringtech.refp.core.entities;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Despesa {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long codDespesa;
	String nrDocumento;
	double vlDespesa;
	Calendar dtDespesa;
}
