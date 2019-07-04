package com.tostringtech.refp.projeto.api.rest.resources;

import com.tostringtech.refp.application.model.FaseInova;

public class InnovationPhaseResource {

    private String value;
    private String name;


    public InnovationPhaseResource(FaseInova faseInovacao) {
        this.setName(faseInovacao.getDescricao());
        this.setValue(faseInovacao.getCodigo());
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
