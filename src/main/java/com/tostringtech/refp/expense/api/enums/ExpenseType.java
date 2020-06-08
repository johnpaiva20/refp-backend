package com.tostringtech.refp.expense.api.enums;

import com.tostringtech.refp.application.exceptions.StandardException;

public enum ExpenseType {
	
	RH("RH"),
	MC("MC"),
	MP("MP"),
	ST("ST"),
	VD("VD"),
	OU("OU");
	
	private String tipo;
	
	ExpenseType(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public static ExpenseType getExpenseType(String tipo) {
		for (ExpenseType type : values()) {
            if (type.tipo.equals(tipo)) {
                return type;
            }
        }
        throw new StandardException(String.format("No enum value %s", tipo));
	}
	
}
