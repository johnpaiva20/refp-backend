package com.tostringtech.refp.expense.api.enums;

import com.tostringtech.refp.application.exceptions.StandardException;

public enum DocumentType {

	NF("NF");
	
	private String tipo;
	
	DocumentType(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public static DocumentType getDocumentType(String tipo) {
		for (DocumentType type : values()) {
            if (type.tipo.equals(tipo)) {
                return type;
            }
        }
        throw new StandardException(String.format("No enum value %s", tipo));
	}
}