package com.atguigu.common.handler;

import com.atguigu.common.pojo.KaleldoResponse;
import com.atguigu.common.utils.KaleldoUtil;
import com.atguigu.common.utils.R;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 处理资源服务异常
 */
public class KaleldoAuthExceptionEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        KaleldoResponse kaleldoResponse = new KaleldoResponse();

        KaleldoUtil.makeResponse(
                response, MediaType.APPLICATION_JSON_UTF8_VALUE,
                HttpServletResponse.SC_UNAUTHORIZED, R.error(401,"token无效")

        );
    }
}
