package com.tostringtech.refp.application.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "SEGMENTO")
public class Segmento {

    @Id
    @ApiModelProperty(hidden = true)
    @Column(name = "CD_SEGMENTO")
    private long codigo;

    @Column(name = "DS_SEGMENTO")
    private String descricao;

    public Segmento() {
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
