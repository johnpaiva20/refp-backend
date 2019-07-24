package com.tostringtech.refp.projeto.api.rest.resources;

import com.tostringtech.refp.application.models.TipoProduto;

public class ProductTypeResource {

    private Long id;
    private String initials;
    private String description;

    public ProductTypeResource() {
    }

    public ProductTypeResource(TipoProduto tipoProduto) {
        this.setId(tipoProduto.getCodigo());
        this.setInitials(tipoProduto.getSigla());
        this.setDescription(tipoProduto.getDescricao());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
