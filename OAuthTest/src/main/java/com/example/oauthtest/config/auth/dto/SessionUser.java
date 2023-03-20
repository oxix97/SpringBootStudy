package com.example.oauthtest.config.auth.dto;

import com.example.oauthtest.domain.entity.UserInfo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(UserInfo userInfo) {
        this.name = userInfo.getName();
        this.email = userInfo.getEmail();
        this.picture = userInfo.getPicture();
    }
}
