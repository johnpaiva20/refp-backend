package com.tostringtech.refp.project.api.resources;

import com.tostringtech.refp.application.models.Tema;

public class TopicResource {

    private Long id;

    private String description;

    private boolean priority;

    private String initials;

    private ProjectTypeResource projectType;

    public TopicResource() {
    }


    public TopicResource(Tema tema) {
        this.setId(tema.getCodigo());
        this.setDescription(tema.getDescricao());
        this.setPriority(tema.getPrioritario().equals("S"));
        this.setInitials(tema.getSigla());
        if(tema.getTipoProjeto()!=null) {
            this.setProjectType(new ProjectTypeResource(tema.getTipoProjeto()));
        }
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
