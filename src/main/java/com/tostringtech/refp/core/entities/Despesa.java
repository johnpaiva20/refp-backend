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

	public Calendar getDtDespesa() {
		return dtDespesa;
	}

	public void setDtDespesa(Calendar dtDespesa) {
		this.dtDespesa = dtDespesa;
	}
}
