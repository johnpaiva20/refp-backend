package com.tostringtech.refp.application.model;

import com.tostringtech.refp.projeto.api.rest.resources.ProductResource;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PRODUTO")
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_PRODUTO")
    private Long codigo;

    @Column(name = "DS_PRODUTO")
    private String descricao;

    @OneToOne()
    @JoinColumn(name = "CD_TIPO_PRODUTO")
    private TipoProduto tipoProduto;

    public Produto() {
    }

    public Produto(ProductResource product) {
        this.setCodigo(product.getId());
        this.setDescricao(product.getDescription());
        if (product.getType() != null) {
            this.setTipoProduto(new TipoProduto(product.getType()));
        }

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

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

}
