package com.tostringtech.refp.projeto.api.rest.resources;

import com.tostringtech.refp.application.models.Projeto;
import io.swagger.annotations.ApiModel;

import java.util.List;
import java.util.stream.Collectors;

@ApiModel(value = "Project")
public class ProjectResource {

    private Long id;

    private String aneelId;

    private String title;

    private int duration;

    private String status;

    private String segment;

    private String innovationPhase;

    private String sharingMethod;

    private ProductResource product;

    private ProjectTypeResource type;

    private TopicResource topic;

    private SubtopicResource subtopic;

    private ServiceOrderResource serviceOrder;

    private List<ProjectEnterpriseResource> enterprises;

    public ProjectResource() {
    }

    public ProjectResource(Projeto projeto) {
        this.setId(projeto.getCodigo());
        this.setAneelId(projeto.getCodigoAneel());
        this.setTitle(projeto.getTitulo());
        this.setDuration(projeto.getDuracao());
        this.setSegment(projeto.getSegmento());
        this.setInnovationPhase(projeto.getFaseInovacao());
        this.setStatus(projeto.getStatus());
        this.setSharingMethod(projeto.getTipoCompartilhamento());

        if (projeto.getOrdemServico() != null) {
            this.setServiceOrder(new ServiceOrderResource(projeto.getOrdemServico()));
        }
        if (projeto.getTipoProjeto() != null) {
            this.setType(new ProjectTypeResource(projeto.getTipoProjeto()));
        }
        if (projeto.getTema() != null) {
            this.setTopic(new TopicResource(projeto.getTema()));
        }
        if (projeto.getSubtema() != null) {
            this.setSubtopic(new SubtopicResource(projeto.getSubtema()));
        }
        if (projeto.getProduto() != null) {
            this.setProduct(new ProductResource(projeto.getProduto()));
        }
       /* if (projeto.getEmpresas() != null) {
            List<ProjectEnterpriseResource> enterprises = projeto.getEmpresas().stream().map(ProjectEnterpriseResource::new).collect(Collectors.toList());
            this.setEnterprises(enterprises);
        }*/
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public String getInnovationPhase() {
        return innovationPhase;
    }

    public void setInnovationPhase(String innovationPhase) {
        this.innovationPhase = innovationPhase;
    }

    public String getSharingMethod() {
        return sharingMethod;
    }

    public void setSharingMethod(String sharingMethod) {
        this.sharingMethod = sharingMethod;
    }

    public ProductResource getProduct() {
        return product;
    }

    public void setProduct(ProductResource product) {
        this.product = product;
    }

    public ProjectTypeResource getType() {
        return type;
    }

    public void setType(ProjectTypeResource type) {
        this.type = type;
    }

    public TopicResource getTopic() {
        return topic;
    }

    public void setTopic(TopicResource topic) {
        this.topic = topic;
    }

    public SubtopicResource getSubtopic() {
        return subtopic;
    }

    public void setSubtopic(SubtopicResource subtopic) {
        this.subtopic = subtopic;
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
