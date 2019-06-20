package com.tostringtech.refp.projeto.controller.resources;

import com.tostringtech.refp.application.model.Empresa;
import com.tostringtech.refp.empresa.controller.resources.EnterpriseResource;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Project Enterprise")
public class ProjectEnterpriseResource extends EnterpriseResource {


    @ApiModelProperty(position = 1)
    private boolean active;

    @ApiModelProperty(position = 2)
    private String type;

    public ProjectEnterpriseResource() {
    }

    public ProjectEnterpriseResource(Long id, String cnpj, String company, String trade, String initials, Boolean active, String type) {
        super(id,cnpj,company,trade,initials);
        this.active = active;
        this.type = type;
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
