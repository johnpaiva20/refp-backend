package com.tostringtech.refp.empresa.controller.resources;

import com.tostringtech.refp.application.model.Empresa;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Enterprise")
public class EnterpriseResource {

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

    public EnterpriseResource() {
    }

    public EnterpriseResource(Long id, String cnpj, String company, String trade, String initials) {
        this.id = id;
        this.cnpj = cnpj;
        this.company = company;
        this.trade = trade;
        this.initials = initials;
    }

    public EnterpriseResource(Empresa empresa) {
        this.id = empresa.getCodigo();
        this.cnpj = empresa.getNumeroCnpj();
        this.company = empresa.getRazaoSocial();
        this.trade = empresa.getNomeFantasia();
        this.initials = empresa.getSigla();
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
}
