package com.jt.secure.config;

import com.jt.secure.filters.DynamicSecurityFilter;
import com.jt.secure.filters.JwtAuthenticationTokenFilter;
import com.jt.secure.handler.RestAuthenticationEntryPoint;
import com.jt.secure.handler.RestfulAccessDeniedHandler;
import com.jt.secure.intercept.DynamicAccessDecisionManager;
import com.jt.secure.service.DynamicSecurityService;
import com.jt.secure.utils.JwtTokenUtil;
import com.jt.secure.yml.SecureIgnoreUrlsYml;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableConfigurationProperties({SecureIgnoreUrlsYml.class})
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

    private final RestfulAccessDeniedHandler restfulAccessDeniedHandler;
    private final RestAuthenticationEntryPoint restAuthenticationEntryPoint;
    private final JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;
    private final DynamicSecurityService dynamicSecurityService;
    private final DynamicSecurityFilter dynamicSecurityFilter;
    private final DynamicAccessDecisionManager dynamicAccessDecisionManager;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity, SecureIgnoreUrlsYml secureIgnoreUrl) throws Exception {

        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = httpSecurity.authorizeRequests();
        // 无需保护的资源路径访问
        for (String ignoreUrl : secureIgnoreUrl.getUrls()) {
            registry.antMatchers(ignoreUrl).permitAll();
        }
        // 允许跨域请求的OPTIONS请求
        registry.antMatchers(HttpMethod.OPTIONS).permitAll();
        // 任何请求需要身份认证
        registry.and().authorizeRequests().anyRequest().authenticated()
                // 关闭跨站请求防护
                .and().csrf().disable()
                // 不使用session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                // 自定义权限拒绝处理类
                .and().exceptionHandling().accessDeniedHandler(restfulAccessDeniedHandler).authenticationEntryPoint(restAuthenticationEntryPoint)
                // 自定义权限拦截器JWT过滤器
                .and().addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class)
        ;
        //有动态权限配置时添加动态权限校验过滤器
        if (dynamicSecurityService != null) {
            registry.and().authorizeRequests().accessDecisionManager(dynamicAccessDecisionManager)
                    .and().addFilterBefore(dynamicSecurityFilter, FilterSecurityInterceptor.class);
        }
        return httpSecurity.build();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtTokenUtil jwtTokenUtil() {
        return new JwtTokenUtil();
    }
}
