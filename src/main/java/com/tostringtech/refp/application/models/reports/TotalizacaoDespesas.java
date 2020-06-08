package com.tostringtech.refp.application.models.reports;

public class TotalizacaoDespesas {
	
	private Long ano;
	
	private String mes;
	
	private double valorRubricaRh = 0;
	
	private double valorRubricaMp = 0;
	
	private double valorRubricaMc = 0;
	
	private double valorRubricaSt = 0;
	
	private double valorRubricaVd = 0;
	
	private double valorRubricaOu = 0;
	
	public Long getAno() {
		return ano;
	}
	
	public void setAno(Long ano) {
		this.ano = ano;
	}
	
	public String getMes() {
		return mes;
	}
	
	public void setMes(String mes) {
		if (!mes.isEmpty()) {
			mes = mes.substring(0, 1)
				.toUpperCase()
				.concat(
					mes.substring(1)
						.toLowerCase()
				);
		}
		this.mes = mes;
	}
	
	public double getValorRubricaRh() {
		return valorRubricaRh;
	}
	
	public void setValorRubricaRh(double valorRubricaRh) {
		this.valorRubricaRh = valorRubricaRh;
	}
	
	public double getValorRubricaMp() {
		return valorRubricaMp;
	}
	
	public void setValorRubricaMp(double valorRubricaMp) {
		this.valorRubricaMp = valorRubricaMp;
	}
	
	public double getValorRubricaMc() {
		return valorRubricaMc;
	}
	
	public void setValorRubricaMc(double valorRubricaMc) {
		this.valorRubricaMc = valorRubricaMc;
	}
	
	public double getValorRubricaSt() {
		return valorRubricaSt;
	}
	
	public void setValorRubricaSt(double valorRubricaSt) {
		this.valorRubricaSt = valorRubricaSt;
	}
	
	public double getValorRubricaVd() {
		return valorRubricaVd;
	}
	
	public void setValorRubricaVd(double valorRubricaVd) {
		this.valorRubricaVd = valorRubricaVd;
	}
	
	public double getValorRubricaOu() {
		return valorRubricaOu;
	}
	
	public void setValorRubricaOu(double valorRubricaOu) {
		this.valorRubricaOu = valorRubricaOu;
	}
	
	public double getValorTotal() {
		return this.valorRubricaRh
				+ this.valorRubricaMp
				+ this.valorRubricaMc
				+ this.valorRubricaSt
				+ this.valorRubricaVd
				+ this.valorRubricaOu;
	}
	
}
