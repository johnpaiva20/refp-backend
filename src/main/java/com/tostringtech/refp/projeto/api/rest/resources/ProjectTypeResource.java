package com.tostringtech.refp.projeto.api.rest.resources;

import com.tostringtech.refp.application.model.TipPro;

public class ProjectTypeResource {

    private String value;
    private String name;
    private boolean active;

    public ProjectTypeResource(String codigo, String nome) {
        this.value = codigo;
        this.name = nome;
    }

    public ProjectTypeResource(TipPro tipoProjeto) {
        this.setName(tipoProjeto.getDescricao());
        this.setValue(tipoProjeto.getCodigo());
        this.setActive(tipoProjeto.getAtivo().equals("S"));
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
