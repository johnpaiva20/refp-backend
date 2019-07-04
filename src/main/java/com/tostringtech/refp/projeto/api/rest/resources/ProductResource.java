package com.tostringtech.refp.projeto.api.rest.resources;

import com.tostringtech.refp.application.model.Produto;

public class ProductResource {

    private Long id;
    private String description;
    private String type;

    public ProductResource() {
    }

    public ProductResource(Produto produto) {
        this.setId(produto.getCodigo());
        this.setDescription(produto.getDescricao());
        this.setType(produto.getTipoProduto());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
