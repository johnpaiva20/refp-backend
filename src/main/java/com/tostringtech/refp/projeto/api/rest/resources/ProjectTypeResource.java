package com.tostringtech.refp.projeto.api.rest.resources;

import com.tostringtech.refp.application.model.TipoProjeto;

public class ProjectTypeResource {

    private String id;
    private String description;
    private boolean active;

    public ProjectTypeResource() {
    }

    public ProjectTypeResource(TipoProjeto tipoProjeto) {
        this.setId(tipoProjeto.getCodigo());
        this.setDescription(tipoProjeto.getDescricao());
        this.setActive(tipoProjeto.getAtivo().equals("S"));
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
