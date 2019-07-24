package com.tostringtech.refp.application.models;

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

    @Column(name = "DS_TIP_PROD")
    private String tipoProduto;

    public Produto() {
    }

    public Produto(ProductResource product) {
        this.setCodigo(product.getId());
        this.setDescricao(product.getDescription());
        this.setTipoProduto(product.getType());

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

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

}
