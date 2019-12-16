package com.tostringtech.refp.application.models;

import com.tostringtech.refp.project.api.resources.ProjectTypeResource;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "TIPO_PROJETO")
public class TipoProjeto implements Serializable {

    @Id
    @Column(name = "CD_TIPO_PROJETO", length = 2)
    private String codigo;

    @Column(name = "DS_TIPO_PROJETO", nullable = false)
    private String descricao;

    @Column(name = "SN_ATIVO", nullable = false)
    private String ativo;

    public TipoProjeto() {
    }

    public TipoProjeto(ProjectTypeResource type) {
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
