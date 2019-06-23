package com.tostringtech.refp.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FASE_INOVA")
public class FaseInova {

    @Id
    @Column(name = "CD_FASE_INOVA", length = 2)
    private String codigo;

    @Column(name = "DS_FASE_INOVA", nullable = false)
    private String descricao;

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