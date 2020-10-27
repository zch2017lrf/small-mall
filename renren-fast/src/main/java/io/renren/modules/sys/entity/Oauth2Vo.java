package io.renren.modules.sys.entity;

import lombok.Data;

@Data
public class Oauth2Vo {
    private String access_token;
    private String token_type;
    private String refresh_token;
    private Integer expires_in;
    private String scope;
    private Integer code;
}
