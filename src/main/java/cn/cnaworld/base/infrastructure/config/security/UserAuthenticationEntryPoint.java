package cn.cnaworld.base.infrastructure.config.security;

import cn.cnaworld.framework.infrastructure.common.statics.constants.HttpCodeConstant;
import cn.cnaworld.framework.infrastructure.utils.http.ResponseResult;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Lucifer
 * @date 2023/3/28
 * @since 1.0.0
 */
public class UserAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException{
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.getWriter().write(JSONObject.toJSONString(ResponseResult.error(HttpCodeConstant.UNAUTHORIZED,"认证失败")));
        response.getWriter().flush();
    }
}
