package com.tostringtech.refp.projeto.api.rest.enums;

public enum ProjectTypeEnum {

    DEVELOPMENT_RESEARCH("PD"),
    ENERGY_EFFICIENCY("EE");

    String id;

    ProjectTypeEnum(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public static ProjectTypeEnum toEnum(String codigo) {

        if (codigo == null) {
            return null;
        }
        for (ProjectTypeEnum tipo : ProjectTypeEnum.values()) {
            if (codigo.equals(tipo.getId())) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("O código do tipo do projeto inválido: " + codigo);
    }
}
