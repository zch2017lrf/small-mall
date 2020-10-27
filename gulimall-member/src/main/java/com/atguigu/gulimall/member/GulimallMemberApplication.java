package com.atguigu.gulimall.member;

import com.atguigu.common.annotation.EnableKaleldoAuthExceptionHandler;
import com.atguigu.common.annotation.EnableKaleldoServerProtect;
import com.atguigu.common.annotation.KaleldoCloudApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * 1、spring-session依赖
 * 2、spring-session配置
 * 3、LoginInterceptor拦截器
 */
@EnableFeignClients("com.atguigu.gulimall.member.feign")
@EnableDiscoveryClient
@SpringBootApplication
@EnableKaleldoAuthExceptionHandler //oauth2服务安全
@EnableGlobalMethodSecurity(prePostEnabled = true) //oauth2服务安全
@KaleldoCloudApplication //oauth2服务安全
@EnableKaleldoServerProtect //防止绕过网关服务
public class GulimallMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallMemberApplication.class, args);
    }

}
