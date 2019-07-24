package com.tostringtech.refp.projeto.api.rest.enums;

public enum BinaryEnum {

    YES("S"),
    NO("N");

    String id;

    BinaryEnum(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public static BinaryEnum toEnum(String codigo) {

        if (codigo == null) {
            return null;
        }
        for (BinaryEnum tipo : BinaryEnum.values()) {
            if (codigo.equals(tipo.getId())) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("O código inválido: " + codigo);
    }
}


