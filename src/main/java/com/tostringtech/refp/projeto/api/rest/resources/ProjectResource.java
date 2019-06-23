package com.tostringtech.refp.projeto.api.rest.resources;

import com.tostringtech.refp.application.model.Projeto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "Project")
public class ProjectResource {

    private Long id;

    private String aneelId;

    private String title;

    private int duration;

    private ServiceOrderResource serviceOrder;

    private String status;

    private ProjectTypeResource type;

    private TopicResource topic;

    private SubtopicResource subtopic;

    private SegmentResource segment;

    private InnovationPhaseResource innovationPhase;

    private ProductResource product;

    public ProjectResource() {
    }

    public ProjectResource(Projeto projeto) {
        this.setId(projeto.getCodigo());
        this.setAneelId(projeto.getCodigoAneel());
        this.setTitle(projeto.getTitulo());
        this.setDuration(projeto.getValorDuracaoMeses());
        this.setStatus("Andamento");

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
        if (projeto.getSegmento() != null) {
            this.setSegment(new SegmentResource(projeto.getSegmento()));
        }
        if (projeto.getFaseInovacao() != null) {
            this.setInnovationPhase(new InnovationPhaseResource(projeto.getFaseInovacao()));
        }
        if (projeto.getProduto() != null) {
            this.setProduct(new ProductResource(projeto.getProduto()));
        }
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

    public ServiceOrderResource getServiceOrder() {
        return serviceOrder;
    }

    public void setServiceOrder(ServiceOrderResource serviceOrder) {
        this.serviceOrder = serviceOrder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public SegmentResource getSegment() {
        return segment;
    }

    public void setSegment(SegmentResource segment) {
        this.segment = segment;
    }

    public InnovationPhaseResource getInnovationPhase() {
        return innovationPhase;
    }

    public void setInnovationPhase(InnovationPhaseResource innovationPhase) {
        this.innovationPhase = innovationPhase;
    }

    public ProductResource getProduct() {
        return product;
    }

    public void setProduct(ProductResource product) {
        this.product = product;
    }
}
