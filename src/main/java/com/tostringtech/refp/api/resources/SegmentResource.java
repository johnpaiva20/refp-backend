package com.tostringtech.refp.api.resources;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Project Type ")
public class SegmentResource {

    @ApiModelProperty(position = 1, readOnly = true)
    private String id;

    @ApiModelProperty(position = 2)
    private String segment;

    public SegmentResource() {
    }

    public SegmentResource(String id, String segment) {
        this.id = id;
        this.segment = segment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }
}
