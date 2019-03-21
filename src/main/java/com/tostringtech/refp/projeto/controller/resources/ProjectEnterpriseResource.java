package com.tostringtech.refp.projeto.controller.resources;

import com.tostringtech.refp.application.model.Empresa;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Project Enterprise")
public class ProjectEnterpriseResource {

    @ApiModelProperty(position = 1, readOnly = true)
    private Long id;

    @ApiModelProperty(position = 2)
    private String cnpj;

    @ApiModelProperty(position = 3)
    private String company;

    @ApiModelProperty(position = 4)
    private String trade;

    @ApiModelProperty(position = 5)
    private String initials;

    @ApiModelProperty(position = 6)
    private boolean active;

    @ApiModelProperty(position = 7)
    private String type;

    public ProjectEnterpriseResource() {
    }

    public ProjectEnterpriseResource(Long id, String cnpj, String company, String trade, String initials, Boolean active, String type) {
        this.id = id;
        this.cnpj = cnpj;
        this.company = company;
        this.trade = trade;
        this.initials = initials;
        this.active = active;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTrade() {
        return trade;
    }

    public void setTrade(String trade) {
        this.trade = trade;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
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
