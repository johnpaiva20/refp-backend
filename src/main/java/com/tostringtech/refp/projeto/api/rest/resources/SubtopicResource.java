package com.tostringtech.refp.projeto.api.rest.resources;

import com.tostringtech.refp.application.model.Subtema;

public class SubtopicResource {

    private Long id;

    private String description;

    private boolean priority;

    private String initials;

    private TopicResource topic;


    public SubtopicResource() {
    }


    public SubtopicResource(Subtema subtema) {
        this.id = subtema.getCodigo();
        this.description = subtema.getDescricao();
        this.priority = subtema.getPrioritario().equals("S");
        this.initials = subtema.getSigla();
        if (subtema.getTema() != null) {
            this.setTopic(new TopicResource(subtema.getTema()));
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

    public TopicResource getTopic() {
        return topic;
    }

    public void setTopic(TopicResource topic) {
        this.topic = topic;
    }
}
