package com.atguigu.common.annotation;

import com.atguigu.common.selector.KaleldoCloudApplicationSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(KaleldoCloudApplicationSelector.class)
public @interface KaleldoCloudApplication {
}
