package com.tostringtech.refp.application.models;

import com.tostringtech.refp.projeto.api.rest.resources.ProductTypeResource;

import javax.persistence.*;

@Entity
@Table(name = "TIPO_PRODUTO")
public class TipoProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_TIPO_PRODUTO")
    private Long codigo;

    @Column(name = "DS_SIGLA")
    private String sigla;

    @Column(name = "DS_TIPO_PRODUTO")
    private String descricao;

    public TipoProduto() {
    }

    public TipoProduto(ProductTypeResource type) {
        this.setCodigo(type.getId());
        this.setSigla(type.getInitials());
        this.setDescricao(type.getDescription());
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
