package com.example.basicloginauthentication.domain;

import lombok.Getter;
import org.springframework.security.core.Authentication;

@Getter
public class SecurityMessage {
    private Authentication auth;
    private String message;

    protected SecurityMessage() {}

    private SecurityMessage(Authentication auth, String message) {
        this.auth = auth;
        this.message = message;
    }

    public static SecurityMessage of(Authentication auth, String message) {
        return new SecurityMessage(auth, message);
    }
}
