package com.tostringtech.refp.projeto.api.rest.resources;

import com.tostringtech.refp.application.model.OrdemServico;

import java.util.Date;

public class ServiceOrderResource {

    private String id;

    private Date begin;

    private Date end;


    public ServiceOrderResource(OrdemServico ordemServico) {
        this.setId(ordemServico.getCodigo());
        this.setBegin(ordemServico.getDataInicio());
        this.setEnd(ordemServico.getDataFim());

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
