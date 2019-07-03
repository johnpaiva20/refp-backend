package com.tostringtech.refp.application.model;

import com.tostringtech.refp.projeto.api.rest.resources.ProductTypeResource;

import javax.persistence.*;

@Entity
@Table(name = "TIP_PROD")
public class TipProd {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_TIP_PROD")
    private Long codigo;

    @Column(name = "DS_TIP_PROD")
    private String descricao;

    public TipProd(ProductTypeResource type) {
        this.setCodigo(type.getId());
        this.setDescricao(type.getDescription());
    }

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
