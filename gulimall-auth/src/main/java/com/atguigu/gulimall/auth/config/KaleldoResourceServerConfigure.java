package com.atguigu.gulimall.auth.config;


import com.atguigu.common.handler.KaleldoAccessDeniedHandler;
import com.atguigu.common.handler.KaleldoAuthExceptionEntryPoint;
import com.atguigu.gulimall.auth.properties.KaleldoAuthProperties;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * 其主要用于资源的保护，客户端只能通过OAuth2协议发放的令牌来从资源服务器中获取受保护的资源
 */
@Configuration
@EnableResourceServer
public class KaleldoResourceServerConfigure extends ResourceServerConfigurerAdapter {

    @Autowired
    private KaleldoAccessDeniedHandler accessDeniedHandler;
    @Autowired
    private KaleldoAuthExceptionEntryPoint exceptionEntryPoint;
    @Autowired
    private KaleldoAuthProperties properties;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        String[] anonUrls = StringUtils.splitByWholeSeparatorPreserveAllTokens(properties.getAnonUrl(), ",");
        http.csrf().disable()
                .requestMatchers().antMatchers("/**")//requestMatchers().antMatchers("/**")的配置表明该安全配置对所有请求都生效
                .and()
                .authorizeRequests()
                //对验证码URL进行放行
                .antMatchers(anonUrls).permitAll()
                .antMatchers("/actuator/**").permitAll()
                .antMatchers("/**").authenticated()
                .and().httpBasic();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.authenticationEntryPoint(exceptionEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);
    }
}

