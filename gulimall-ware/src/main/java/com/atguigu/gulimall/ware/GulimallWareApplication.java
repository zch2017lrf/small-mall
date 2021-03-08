package com.atguigu.gulimall.ware;

import com.atguigu.common.annotation.EnableKaleldoAuthExceptionHandler;
import com.atguigu.common.annotation.EnableKaleldoServerProtect;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableKaleldoAuthExceptionHandler//处理ouath2异常及资源异常
@EnableKaleldoServerProtect //防止绕过网关服务
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.atguigu.gulimall.ware.dao")
@SpringBootApplication
public class GulimallWareApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallWareApplication.class, args);
    }

}
