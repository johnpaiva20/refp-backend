package com.tostringtech.refp.projeto.api.rest.resources;

import com.tostringtech.refp.application.model.Segmento;

public class SegmentResource {

    String value;
    String name;

    public SegmentResource() {
    }

    public SegmentResource(Segmento segmento) {

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
