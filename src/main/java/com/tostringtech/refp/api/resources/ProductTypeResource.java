package com.tostringtech.refp.api.resources;

import io.swagger.annotations.ApiModelProperty;

public class ProductTypeResource {

    @ApiModelProperty(position = 1, readOnly = true)
    private String id;

    @ApiModelProperty(position = 2)
    private String product;

    public ProductTypeResource() {
    }

    public ProductTypeResource(String id, String product) {
        this.id = id;
        this.product = product;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
