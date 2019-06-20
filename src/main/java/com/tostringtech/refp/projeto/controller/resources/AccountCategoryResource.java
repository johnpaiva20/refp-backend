package com.tostringtech.refp.projeto.controller.resources;

import com.tostringtech.refp.application.model.CategoriaContabil;

public class AccountCategoryResource {

    private Long id;

    private String description;

    private String projectType;

    private String initials;

    private String standard;


    public AccountCategoryResource(CategoriaContabil categoriaContabil) {
        this.id = categoriaContabil.getCodigo();
        this.description = categoriaContabil.getDescricao();
        this.projectType = categoriaContabil.getTipoProjeto();
        this.initials = categoriaContabil.getSigla();
        this.standard = categoriaContabil.getPadrao();
    }

    public AccountCategoryResource(Long id, String description, String projectType, String initials, String standard) {
        this.id = id;
        this.description = description;
        this.projectType = projectType;
        this.initials = initials;
        this.standard = standard;
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

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }
}
