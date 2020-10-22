package com.atguigu.common.annotation;

import com.atguigu.common.configure.KaleldoServerProtectConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(KaleldoServerProtectConfigure.class)
public @interface EnableKaleldoServerProtect {
}

