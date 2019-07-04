package com.tostringtech.refp.projeto.api.rest.resources;

import com.tostringtech.refp.application.model.FaseInova;

public class InnovationPhaseResource {

    private String id;
    private String description;


    public InnovationPhaseResource(FaseInova faseInovacao) {
        this.setId(faseInovacao.getDescricao());
        this.setDescription(faseInovacao.getCodigo());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
