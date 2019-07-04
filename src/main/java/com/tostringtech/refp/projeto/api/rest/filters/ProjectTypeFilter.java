package com.tostringtech.refp.projeto.api.rest.filters;

import com.tostringtech.refp.projeto.api.rest.enums.ProjectTypeEnum;

public class ProjectTypeFilter {

    ProjectTypeEnum type;

    public ProjectTypeEnum getType() {
        return type;
    }

    public void setType(ProjectTypeEnum type) {
        this.type = type;
    }

}
