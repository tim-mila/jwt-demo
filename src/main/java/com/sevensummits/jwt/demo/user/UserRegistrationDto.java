package com.sevensummits.jwt.demo.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRegistrationDto {

    private final String username;
    private final String password;

    @JsonCreator
    UserRegistrationDto(@JsonProperty final String username, @JsonProperty final String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
