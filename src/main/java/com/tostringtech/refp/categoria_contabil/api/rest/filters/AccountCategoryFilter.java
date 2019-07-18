package com.tostringtech.refp.categoria_contabil.api.rest.filters;

import com.tostringtech.refp.projeto.api.rest.enums.ProjectTypeEnum;

public class AccountCategoryFilter {

    ProjectTypeEnum type;

    public ProjectTypeEnum getType() {
        return type;
    }

    public void setType(ProjectTypeEnum type) {
        this.type = type;
    }
}
