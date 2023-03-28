package cn.cnaworld.base.infrastructure.config.security;

import cn.cnaworld.base.domain.login.service.UserDetailsImpl;
import cn.cnaworld.base.domain.user.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lucifer
 * @date 2023/3/28
 * @since 1.0.0
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig {

    @Autowired
    private UserDetailsImpl userDetailsImpl;

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private AuthenticationManager authenticationManager;

    private static final List<String> PERMIT_STATIC;
    private static final List<String> PERMIT_METHOD;
    static {
        PERMIT_STATIC = new ArrayList<>();
        PERMIT_STATIC.add("/*.html");
        PERMIT_STATIC.add("/favicon.ico");
        PERMIT_STATIC.add("/**/*.html");
        PERMIT_STATIC.add("/**/*.css");
        PERMIT_STATIC.add("/**/*.js");
        PERMIT_STATIC.add("/**/*.png");
        PERMIT_STATIC.add("/**/*.jpg");
        PERMIT_STATIC.add("/**/*.ttf");
        PERMIT_STATIC.add("/**/*.woff");
        PERMIT_STATIC.add("/**/*.wav");
        PERMIT_STATIC.add("/swagger-ui.html");

        PERMIT_METHOD = new ArrayList<>();
        PERMIT_METHOD.add("/swagger-resources");
        PERMIT_METHOD.add("/v2/api-docs");
        PERMIT_METHOD.add("/v3/api-docs");
        PERMIT_METHOD.add("/login");
        PERMIT_METHOD.add("/");
    }

    /**
     * 获取AuthenticationManager（认证管理器），登录时认证使用
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                // 基于 token，不需要 csrf
                .csrf().disable()
                // 基于 token，不需要 session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                // 下面开始设置权限
                .authorizeRequests(authorize -> authorize
                        .antMatchers(PERMIT_STATIC.toArray(new String[0])).permitAll()
                        .antMatchers(PERMIT_METHOD.toArray(new String[0])).permitAll()
                        // 其他地址的访问均需验证权限
                        .anyRequest().authenticated())
                .addFilter(new JWTAuthenticationFilter(authenticationManager, sysUserService))
                .exceptionHandling().authenticationEntryPoint(new UserAuthenticationEntryPoint()).and()
                // 认证用户时用户信息加载配置，注入springAuthUserService
                .userDetailsService(userDetailsImpl).build();
    }

    /**
     * 密码明文加密方式配置（使用国密SM4）
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new SCryptPasswordEncoder();
    }

    /**
     * 配置跨源访问(CORS)
     */
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }
}
