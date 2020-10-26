package com.atguigu.gulimall.auth.properties;

import lombok.Data;

@Data
public class KaleldoClientsProperties {
    private String client;
    private String secret;
    private String grantType = "password,authorization_code,refresh_token";
    private String scope = "all";
}
