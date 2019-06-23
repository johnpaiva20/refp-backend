package com.tostringtech.refp.projeto.api.rest.resources;

import com.tostringtech.refp.application.model.TipProd;

public class ProductTypeResource {

    private Long id;
    private String description;

    public ProductTypeResource(TipProd tipoProduto) {
        this.setId(tipoProduto.getCodigo());
        this.setDescription(tipoProduto.getDescricao());
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
}
