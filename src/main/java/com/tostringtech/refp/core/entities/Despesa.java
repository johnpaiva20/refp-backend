package com.tostringtech.refp.core.entities;

import java.util.Calendar;
import java.util.Date;

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
	Date dtDespesa;

	public Despesa() {
	
	}

	public Despesa(Long codDespesa, String nrDocumento, double vlDespesa, Date dtDespesa) {
		this.codDespesa = codDespesa;
		this.nrDocumento = nrDocumento;
		this.vlDespesa = vlDespesa;
		this.dtDespesa = dtDespesa;
	}

	public Long getCodDespesa() {
		return codDespesa;
	}

	public void setCodDespesa(Long codDespesa) {
		this.codDespesa = codDespesa;
	}

	public String getNrDocumento() {
		return nrDocumento;
	}

	public void setNrDocumento(String nrDocumento) {
		this.nrDocumento = nrDocumento;
	}

	public double getVlDespesa() {
		return vlDespesa;
	}

	public void setVlDespesa(double vlDespesa) {
		this.vlDespesa = vlDespesa;
	}

	public Date getDtDespesa() {
		return dtDespesa;
	}

	public void setDtDespesa(Date dtDespesa) {
		this.dtDespesa = dtDespesa;
	}
}
