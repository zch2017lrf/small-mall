package com.atguigu.gulimall.product.config;


import com.atguigu.common.handler.KaleldoAccessDeniedHandler;
import com.atguigu.common.handler.KaleldoAuthExceptionEntryPoint;
import com.atguigu.gulimall.product.properties.KaleldoServerSystemProperties;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * 资源管理器
 */
@Configuration
@EnableResourceServer
public class KaleldoServerSystemResourceServerConfigure extends ResourceServerConfigurerAdapter {
    @Autowired
    private KaleldoAccessDeniedHandler accessDeniedHandler;
    @Autowired
    private KaleldoAuthExceptionEntryPoint exceptionEntryPoint;
    @Autowired
    private KaleldoServerSystemProperties properties;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        //获取免认证url
        String[] anonUrls = StringUtils.splitByWholeSeparatorPreserveAllTokens(properties.getAnonUrl(), ",");
        http.csrf().disable()
                .requestMatchers().antMatchers("/**")
                .and()
                .authorizeRequests()
                .antMatchers(anonUrls).permitAll()
                .antMatchers("/actuator/**").permitAll()
                .antMatchers("/**").authenticated();
    }
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.authenticationEntryPoint(exceptionEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);
    }
}
