package com.tostringtech.refp.project.api.resources;

import com.tostringtech.refp.application.models.EmpPro;
import com.tostringtech.refp.enterprise.api.resources.EnterpriseResource;


public class ProjectEnterpriseResource {

    private Long id;

    private ProjectResource project;

    private EnterpriseResource enterprise;

    private boolean active;

    private String type;

    public ProjectEnterpriseResource() {
    }

    public ProjectEnterpriseResource(EmpPro empPro) {
        this.setId(empPro.getCodigo());
        this.setActive(empPro.getAtivo());
        this.setType(empPro.getTipoEmpresa());
        if (empPro.getEmpresa() != null) {
            this.setEnterprise(new EnterpriseResource(empPro.getEmpresa()));
        }
        if (empPro.getProjeto() != null) {
            this.setProject(new ProjectResource(empPro.getProjeto()));
        }
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProjectResource getProject() {
        return project;
    }

    public void setProject(ProjectResource project) {
        this.project = project;
    }

    public EnterpriseResource getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(EnterpriseResource enterprise) {
        this.enterprise = enterprise;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setActive(String active) {
        if (!(active == null || (!active.equals("S") && !active.equals("N")))) {
            this.active = active.equals("S") ? true : false;
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}