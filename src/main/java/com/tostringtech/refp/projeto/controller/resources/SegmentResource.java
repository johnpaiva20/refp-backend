package com.tostringtech.refp.projeto.controller.resources;

public class SegmentResource {

    String value;
    String name;

    public SegmentResource() {
    }

    public SegmentResource(String codigo, String nome) {
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
