package com.tostringtech.refp.project.api.resources;

import com.tostringtech.refp.application.models.Projeto;
import com.tostringtech.refp.project.api.enums.ProjectType;
import io.swagger.annotations.ApiModel;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

@ApiModel(value = "Project")
public class ProjectResource {

    private Long id;

    private String aneelId;

    private String title;

    private ProjectType type;

    private ServiceOrderResource serviceOrder;

    private List<ProjectEnterpriseResource> enterprises = new ArrayList<>();

    public ProjectResource() {
    }

    public ProjectResource(Projeto projeto) {
        this.setId(projeto.getCodigo());
        this.setAneelId(projeto.getCodigoAneel());
        this.setTitle(projeto.getTitulo());
        this.setType(ProjectType.getProjectType(projeto.getTipo()));
        if (projeto.getOrdemServico() != null) {
            this.setServiceOrder(new ServiceOrderResource(projeto.getOrdemServico()));
        }
        List<ProjectEnterpriseResource> resourceList = projeto
                .getEmpresas()
                .stream()
                .map(ProjectEnterpriseResource::new)
                .collect(Collectors.toList());

        this.getEnterprises().addAll(resourceList);

    }

    public ProjectResource(LinkedHashMap project) {
        this.setId((Long) project.get("id"));
        this.setAneelId((String) project.get("aneelId"));
        this.setTitle((String) project.get("title"));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAneelId() {
        return aneelId;
    }

    public void setAneelId(String aneelId) {
        this.aneelId = aneelId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ProjectType getType() {
        return type;
    }

    public void setType(ProjectType type) {
        this.type = type;
    }

    public ServiceOrderResource getServiceOrder() {
        return serviceOrder;
    }

    public void setServiceOrder(ServiceOrderResource serviceOrder) {
        this.serviceOrder = serviceOrder;
    }

    public List<ProjectEnterpriseResource> getEnterprises() {
        return enterprises;
    }

    public void setEnterprises(List<ProjectEnterpriseResource> enterprises) {
        this.enterprises = enterprises;
    }
}
