package com.tostringtech.refp.application.authentication.api.rest.resources;

public class TokenResource {
    private String username;
    private Object token;

    public TokenResource() {
    }

    public TokenResource(String username, Object token) {
        this.username = username;
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Object getToken() {
        return token;
    }

    public void setToken(Object token) {
        this.token = token;
    }
}
