package com.in28minutes.rest.basic.auth;

public class AuthenticationBean {

    private final String message;

    public AuthenticationBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
