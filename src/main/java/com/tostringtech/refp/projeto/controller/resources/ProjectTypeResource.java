package com.tostringtech.refp.projeto.controller.resources;

public class ProjectTypeResource {

    private String value;
    private String name;

    public ProjectTypeResource(String codigo, String nome) {
        this.value = codigo;
        this.name = nome;
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
