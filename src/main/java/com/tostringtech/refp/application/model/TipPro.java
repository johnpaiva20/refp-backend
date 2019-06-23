package com.tostringtech.refp.application.model;

import javax.persistence.*;

@Entity
@Table(name = "TIP_PRO")
public class TipPro {

    @Id
    @Column(name = "CD_TIP_PRO",length = 2)
    private String codigo;

    @Column(name = "DS_TIP_PRO", nullable = false)
    private String descricao;

    @Column(name = "SN_ATIVO", nullable = false)
    private String ativo;

    public TipPro() {
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
}
