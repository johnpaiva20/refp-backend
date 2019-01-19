package com.tostringtech.refp.api.resources;

import io.swagger.annotations.ApiModelProperty;

public class ProjectTypeResource {

    @ApiModelProperty(position = 1, readOnly = true)
    private String id;

    @ApiModelProperty(position = 2)
    private String type;

    @ApiModelProperty(position = 3)
    private boolean active;

    public ProjectTypeResource() {
    }

    public ProjectTypeResource(String id, String type, boolean active) {
        this.id = id;
        this.type = type;
        this.active = active;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
