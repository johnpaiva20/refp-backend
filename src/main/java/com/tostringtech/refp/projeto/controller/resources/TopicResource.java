package com.tostringtech.refp.projeto.controller.resources;

import com.tostringtech.refp.application.model.Subtema;
import com.tostringtech.refp.application.model.Tema;

public class TopicResource {

    private Long id;

    private String description;

    private String projectType;

    private boolean priority;

    private String initials;

    public TopicResource() {
    }

    public TopicResource(Long id, String description, String projectType, boolean priority, String initials) {
        this.id = id;
        this.description = description;
        this.projectType = projectType;
        this.priority = priority;
        this.initials = initials;
    }

    public TopicResource(Tema tema) {
        this.id = tema.getCodigo();
        this.description = tema.getDescricao();
        this.projectType = tema.getTipoProjeto();
        this.priority = tema.getPrioritario().equals("S");
        this.initials = tema.getSigla();
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

    public boolean isPriority() {
        return priority;
    }

    public void setPriority(boolean priority) {
        this.priority = priority;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }
}
