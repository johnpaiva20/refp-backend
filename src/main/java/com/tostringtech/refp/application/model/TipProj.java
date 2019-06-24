package com.tostringtech.refp.application.model;

import com.tostringtech.refp.projeto.api.rest.resources.ProjectTypeResource;

import javax.persistence.*;

@Entity
@Table(name = "TIP_PROJ")
public class TipProj {

    @Id
    @Column(name = "CD_TIP_PROJ", length = 2)
    private String codigo;

    @Column(name = "DS_TIP_PROJ", nullable = false)
    private String descricao;

    @Column(name = "SN_ATIVO", nullable = false)
    private String ativo;

    public TipProj() {
    }

    public TipProj(ProjectTypeResource type) {
        this.setCodigo(type.getId());
        this.setDescricao(type.getDescription());
        this.setAtivo(type.isActive());
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

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo ? "S" : "N";
    }
}
