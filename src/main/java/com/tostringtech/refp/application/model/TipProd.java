package com.tostringtech.refp.application.model;

import javax.persistence.*;

@Entity
@Table(name = "TIP_PROD")
public class TipProd {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_TIP_PRO")
    private Long codigo;

    @Column(name = "DS_TIP_PRO")
    private String descricao;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
