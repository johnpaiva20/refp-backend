package com.tostringtech.refp.application.models;

import com.tostringtech.refp.projeto.api.rest.resources.SegmentResource;

//@Entity
//@Table(name = "SEGMENTO")
public class Segmento {

    //@Id
    //@Column(name = "CD_SEGMENTO")
    private String codigo;

    //@Column(name = "DS_SEGMENTO")
    private String descricao;

    public Segmento() {
    }

    public Segmento(SegmentResource segment) {
        this.setCodigo(segment.getId());
        this.setDescricao(segment.getDescription());
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}