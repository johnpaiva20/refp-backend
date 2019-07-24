package com.tostringtech.refp.projeto.api.rest.resources;

import com.tostringtech.refp.application.models.Segmento;

public class SegmentResource {

    String id;
    String description;

    public SegmentResource() {
    }

    public SegmentResource(Segmento segmento) {
        this.setId(segmento.getCodigo());
        this.setDescription(segmento.getDescricao());
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
