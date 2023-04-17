package com.example.securitytest.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.Authentication;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class SecurityMessage {
    private Authentication auth;
    private String msg;
}
