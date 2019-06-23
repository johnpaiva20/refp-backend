package com.tostringtech.refp.empresa.api.rest.resources;

import com.tostringtech.refp.application.model.Empresa;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Enterprise")
public class EnterpriseResource {

    private Long id;

    private String cnpj;

    private String company;

    private String trade;

    private String initials;

    public EnterpriseResource() {
    }

    public EnterpriseResource(Empresa empresa) {
      this.setId(empresa.getCodigo());
      this.setCnpj(empresa.getNumeroCnpj());
      this.setCompany(empresa.getRazaoSocial());
      this.setTrade(empresa.getNomeFantasia());
      this.setInitials(empresa.getSigla());
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
