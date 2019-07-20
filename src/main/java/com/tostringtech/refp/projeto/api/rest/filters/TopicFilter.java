package com.tostringtech.refp.projeto.api.rest.filters;

import com.tostringtech.refp.projeto.api.rest.enums.BinaryEnum;
import com.tostringtech.refp.projeto.api.rest.enums.ProjectTypeEnum;

public class TopicFilter {

    ProjectTypeEnum type;

    BinaryEnum priority;

    public ProjectTypeEnum getType() {
        return type;
    }

    public void setType(ProjectTypeEnum type) {
        this.type = type;
    }

    public BinaryEnum getPriority() {
        return priority;
    }

    public void setPriority(BinaryEnum priority) {
        this.priority = priority;
    }
}
