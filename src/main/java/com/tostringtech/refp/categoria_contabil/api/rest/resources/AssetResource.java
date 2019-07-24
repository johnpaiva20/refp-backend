package com.tostringtech.refp.categoria_contabil.api.rest.resources;

import com.tostringtech.refp.application.models.Recurso;

public class AssetResource {

    private Long id;
    private String description;
    private Long idAccountCategory;
    private String descriptionAccountCategory;

    public AssetResource() {
    }

    public AssetResource(Long id, String description, Long idAccountCategory, String descriptionAccountCategory) {
        this.id = id;
        this.description = description;
        this.idAccountCategory = idAccountCategory;
        this.descriptionAccountCategory = descriptionAccountCategory;
    }

    public AssetResource(Recurso rec) {
        this.id = rec.getCodigo();
        this.description = rec.getDescricao();
        this.idAccountCategory = rec.getCategoriaContabil().getCodigo();
        this.descriptionAccountCategory = rec.getCategoriaContabil().getDescricao();
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

    public Long getIdAccountCategory() {
        return idAccountCategory;
    }

    public void setIdAccountCategory(Long idAccountCategory) {
        this.idAccountCategory = idAccountCategory;
    }

    public String getDescriptionAccountCategory() {
        return descriptionAccountCategory;
    }

    public void setDescriptionAccountCategory(String descriptionAccountCategory) {
        this.descriptionAccountCategory = descriptionAccountCategory;
    }
}
