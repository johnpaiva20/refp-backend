package com.tostringtech.refp.projeto.controller.resources;

import com.tostringtech.refp.application.model.Subtema;

public class SubtopicResource {

    private Long id;

    private String description;

    private boolean priority;

    private String initials;

    private String topic;


    public SubtopicResource() {
    }

    public SubtopicResource(Long id, String description, boolean priority, String initials, String topic) {
        this.id = id;
        this.description = description;
        this.priority = priority;
        this.initials = initials;
        this.topic = topic;
    }

    public SubtopicResource(Subtema subtema) {
        this.id = subtema.getCodigo();
        this.description = subtema.getDescricao();
        this.priority = subtema.getPrioritario().equals("S");
        this.initials = subtema.getSigla();
        this.topic = subtema.getTema();
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

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
