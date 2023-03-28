package cn.cnaworld.base.infrastructure.config.security;

import cn.cnaworld.base.domain.user.entity.SysUser;
import cn.cnaworld.base.domain.user.service.ISysUserService;
import cn.cnaworld.base.infrastructure.utils.jwt.JwtUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Lucifer
 * @date 2023/3/28
 * @since 1.0.0
 */
public class JWTAuthenticationFilter extends BasicAuthenticationFilter {

    private final ISysUserService sysUserService;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager,ISysUserService sysUserService) {
        super(authenticationManager);
        this.sysUserService=sysUserService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String jwt = JwtUtil.getJwt(request);
        if (!StringUtils.hasLength(jwt)) {
            chain.doFilter(request, response);
            return;
        }
        // 如果请求头中有token，则进行解析，并且设置认证信息
        SysUser sysUser = JwtUtil.decodedJwt(jwt);
        if (ObjectUtils.isEmpty(sysUser)) {
            chain.doFilter(request, response);
            return;
        }
        // 清空“密码”属性
        // 创建验证通过的令牌对象
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_account",sysUser.getUserName());
        sysUser = sysUserService.getOne(queryWrapper);
        if (ObjectUtils.isEmpty(sysUser)) {
            chain.doFilter(request, response);
            return;
        }
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(sysUser, null, sysUser.getAuthorities());
        // 设置令牌到安全上下文中
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request, response);
    }

}
