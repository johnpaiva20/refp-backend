package com.tostringtech.refp.project.api.enums;

import com.tostringtech.refp.application.exceptions.StandardException;

public enum ProjectType {
    DEVELOPMENT_SEARCH("PD"),
    ENERGY_EFFICIENCY("EE");
    private String tipo;

    ProjectType(String tipo) {
        this.tipo = tipo;
    }

    public String getType() {
        return this.tipo;
    }

    public static ProjectType getProjectType(String tipo) {
        for (ProjectType type : values()) {
            if (type.tipo.equals(tipo)) {
                return type;
            }
        }
        throw new StandardException(String.format("No enum value %s", tipo));
    }

}
