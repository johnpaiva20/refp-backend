package com.tostringtech.refp.application.authentication.api.rest.resources;

import com.tostringtech.refp.application.authentication.core.models.User;

import javax.persistence.Column;

public class UserResource {

    private Long id;

    private String username;

    private String password;

    public UserResource() {
    }

    public UserResource(User user) {
        this.setId(user.getId());
        this.setUsername(user.getUsername());
        this.setPassword(user.getPassword());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
