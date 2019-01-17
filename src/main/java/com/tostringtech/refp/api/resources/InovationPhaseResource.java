package com.tostringtech.refp.api.resources;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Inovation Phase")
public class InovationPhaseResource {

    @ApiModelProperty(position = 1, readOnly = true)
    private String id;

    @ApiModelProperty(position = 2)
    private String innovationPhase;

    public InovationPhaseResource() {
    }

    public InovationPhaseResource(String id, String innovationPhase) {
        this.id = id;
        this.innovationPhase = innovationPhase;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInnovationPhase() {
        return innovationPhase;
    }

    public void setInnovationPhase(String innovationPhase) {
        this.innovationPhase = innovationPhase;
    }
}
