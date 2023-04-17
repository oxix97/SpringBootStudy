package com.example.securitytest.web;

import com.example.securitytest.web.dto.SecurityMessage;
import org.springframework.security.access.prepost.PreAuthorize;

public interface AnyController {
    @PreAuthorize(value = "hasAuthority('ROLE_USER')")
    public SecurityMessage user();

    @PreAuthorize(value = "hasAuthority('ROLE_ADMIN')")
    public SecurityMessage admin();
}
