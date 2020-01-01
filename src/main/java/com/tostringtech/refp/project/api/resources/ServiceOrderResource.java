package com.tostringtech.refp.project.api.resources;

import com.tostringtech.refp.application.models.OrdemServico;

import java.util.Date;

public class ServiceOrderResource {

    private Long id;

    private String order;

    private int duration;

    private Date begin;

    private Date end;

    public ServiceOrderResource() {
    }

    public ServiceOrderResource(OrdemServico ordemServico) {
        this.setId(ordemServico.getCodigo());
        this.setOrder(ordemServico.getOrdem());
        this.setBegin(ordemServico.getDataInicio());
        this.setEnd(ordemServico.getDataFim());
        this.setDuration(ordemServico.getDuracao());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
