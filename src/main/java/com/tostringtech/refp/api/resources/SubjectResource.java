package com.tostringtech.refp.api.resources;

import java.util.ArrayList;
import java.util.List;

public class SubjectResource {

    private String id;
    private String subject;

    private List<SubSubjectResource> subSubjects = new ArrayList<>();

    public SubjectResource() {
    }

    public SubjectResource(String id, String subject) {
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


    public List<SubSubjectResource> getSubSubjects() {
        return subSubjects;
    }

    public void setSubSubjects(List<SubSubjectResource> subSubjects) {
        this.subSubjects = subSubjects;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
