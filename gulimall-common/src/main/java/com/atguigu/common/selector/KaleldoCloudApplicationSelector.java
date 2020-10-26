package com.atguigu.common.selector;

import com.atguigu.common.configure.KaleldoAuthExceptionConfigure;
import com.atguigu.common.configure.KaleldoOAuth2FeignConfigure;
import com.atguigu.common.configure.KaleldoServerProtectConfigure;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class KaleldoCloudApplicationSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{
                KaleldoAuthExceptionConfigure.class.getName(),
                KaleldoOAuth2FeignConfigure.class.getName(),
                KaleldoServerProtectConfigure.class.getName()
        };
    }
}
