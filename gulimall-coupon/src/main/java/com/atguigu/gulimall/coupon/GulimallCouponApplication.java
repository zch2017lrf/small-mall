package com.atguigu.gulimall.coupon;

import com.atguigu.common.annotation.EnableKaleldoAuthExceptionHandler;
import com.atguigu.common.annotation.EnableKaleldoServerProtect;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableKaleldoAuthExceptionHandler//处理ouath2异常及资源异常
@EnableKaleldoServerProtect //防止绕过网关服务
@EnableDiscoveryClient
@MapperScan("com.atguigu.gulimall.coupon.dao")
@SpringBootApplication
public class GulimallCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallCouponApplication.class, args);
    }

}
