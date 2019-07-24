package com.tostringtech.refp.projeto.api.rest.resources;

import com.tostringtech.refp.application.models.CategoriaContabil;

public class AccountCategoryResource {

    private Long id;

    private String description;

    private ProjectTypeResource projectType;

    private String initials;

    private String standard;

    public AccountCategoryResource() {
    }

    public AccountCategoryResource(CategoriaContabil categoriaContabil) {
        this.setId(categoriaContabil.getCodigo());
        this.setDescription(categoriaContabil.getDescricao());
        this.setProjectType(new ProjectTypeResource(categoriaContabil.getTipoProjeto()));
        this.setInitials(categoriaContabil.getSigla());
        this.setStandard(categoriaContabil.getPadrao());

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

    public ProjectTypeResource getProjectType() {
        return projectType;
    }

    public void setProjectType(ProjectTypeResource projectType) {
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
