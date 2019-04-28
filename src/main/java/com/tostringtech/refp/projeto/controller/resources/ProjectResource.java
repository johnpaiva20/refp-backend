package com.tostringtech.refp.projeto.controller.resources;

import com.tostringtech.refp.application.model.Projeto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "Project")
public class ProjectResource {

    @ApiModelProperty(position = 1, readOnly = true)
    private Long id;

    @ApiModelProperty(position = 2)
    private String aneelId;

    @ApiModelProperty(position = 3)
    private String title;

    @ApiModelProperty(position = 4)
    private Date startDate;

    @ApiModelProperty(position = 5)
    private int duration;

    @ApiModelProperty(position = 6)
    private String serviceOrder;

    @ApiModelProperty(position = 7)
    private String status;

    @ApiModelProperty(position = 8)
    private String type;

    @ApiModelProperty(position = 9)
    private String topic;

    @ApiModelProperty(position = 10)
    private String subtopic;

    @ApiModelProperty(position = 11)
    private String segment;

    @ApiModelProperty(position = 12)
    private String innovationPhase;

    @ApiModelProperty(position = 13)
    private String product;

    public ProjectResource() {
    }

    public ProjectResource(Long id, String aneelId, String title, Date startDate, int duration, String serviceOrder, String status, String type, String topic, String subtopic, String segment, String innovationPhase, String product) {
        this.id = id;
        this.aneelId = aneelId;
        this.title = title;
        this.startDate = startDate;
        this.duration = duration;
        this.serviceOrder = serviceOrder;
        this.status = status;
        this.type = type;
        this.topic = topic;
        this.subtopic = subtopic;
        this.segment = segment;
        this.innovationPhase = innovationPhase;
        this.product = product;
    }

    public ProjectResource(Projeto projeto) {
        this.id = projeto.getCodigo();
        this.aneelId = projeto.getCodigoAneel();
        this.title = projeto.getTitulo();
        this.startDate = projeto.getDataInicio();
        this.duration = projeto.getValorDuracaoMeses();
        this.serviceOrder = projeto.getOrdemServico();
        this.status = projeto.getStatus();
        this.type = projeto.getTipoProjeto();
        this.topic = projeto.getTema();
        this.subtopic = projeto.getSubtema();
        this.segment = projeto.getSegmento();
        this.innovationPhase = projeto.getFaseInovacao();
        this.product = projeto.getProduto();
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getServiceOrder() {
        return serviceOrder;
    }

    public void setServiceOrder(String serviceOrder) {
        this.serviceOrder = serviceOrder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getSubtopic() {
        return subtopic;
    }

    public void setSubtopic(String subtopic) {
        this.subtopic = subtopic;
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

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }


}
