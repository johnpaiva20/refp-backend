package com.tostringtech.refp.projeto.api.rest.resources;

import com.tostringtech.refp.application.model.TipProd;

public class ProductTypeResource {

    private String id;
    private String description;

    public ProductTypeResource() {
    }

    public ProductTypeResource(TipProd tipoProduto) {
        this.setId(tipoProduto.getCodigo());
        this.setDescription(tipoProduto.getDescricao());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
