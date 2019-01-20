package com.tostringtech.refp.api.resources;

import javax.persistence.Column;

public class SubSubjectResource {

    private String id;

    private String subject;

    public SubSubjectResource() {
    }

    public SubSubjectResource(String id, String subject) {
        this.id = id;
        this.subject = subject;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
