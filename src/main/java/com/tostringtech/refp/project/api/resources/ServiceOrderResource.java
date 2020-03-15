package com.tostringtech.refp.project.api.resources;

import com.tostringtech.refp.application.models.OrdemServico;

import java.util.Date;

public class ServiceOrderResource {

    private Long id;

    private String number;

    private int duration;

    private Date begin;

    private Date end;

    public ServiceOrderResource() {
    }

    public ServiceOrderResource(OrdemServico ordemServico) {
        this.setId(ordemServico.getCodigo());
        this.setNumber(ordemServico.getNumero());
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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
