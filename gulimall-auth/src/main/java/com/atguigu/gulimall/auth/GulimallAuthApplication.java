package com.atguigu.gulimall.auth;

import com.atguigu.common.annotation.EnableKaleldoAuthExceptionHandler;
import com.atguigu.common.annotation.EnableKaleldoLettuceRedis;
import com.atguigu.common.annotation.EnableKaleldoServerProtect;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableKaleldoAuthExceptionHandler//处理ouath2异常及资源异常
@EnableKaleldoServerProtect //防止绕过网关服务
@MapperScan("com.atguigu.gulimall.auth.mapper")//将路径下的Mapper类都注册到IOC容器中
@EnableKaleldoLettuceRedis //redis缓存配置
@EnableDiscoveryClient
@SpringBootApplication
public class GulimallAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallAuthApplication.class, args);
    }

}
