package com.apkkids.config;

import com.apkkids.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * @Description 系统的Web安全配置类，主要的Spring Security配置都在此类中
 * @Author alex
 * @Date 2019/3/4 0004 下午 9:27
 */
@EnableWebSecurity
public class MainWebSecurityConfigurer extends WebSecurityConfigurerAdapter {
    @Autowired
    BackdoorAuthenticationProvider backdoorAuthenticationProvider;
    @Autowired
    AdminService adminService;
    @Autowired
    MySecurityMetadataSource mySecurityMetadataSource;

    @Autowired
    MyAccessDecisionManager myAccessDecisionManager;
    @Autowired
    MyAccessDeniedHandler myAccessDeniedHandler;

    /**
     * 该方法用于向Spring Security的验证链中插入用户自定义的验证器AuthenticationProvider
     * 用户输入的用户名/密码一旦通过了任何一个验证器的验证，则视为验证成功
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //插入一个后门验证类，演示如何给系统预留后门，它在验证链中加入了一个自定义的BackdoorAuthenticationProvider
        auth.authenticationProvider(backdoorAuthenticationProvider);
        //加入数据库验证类，下面的语句实际上在验证链中加入了一个DaoAuthenticationProvider
        auth.userDetailsService(adminService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //访问以下网址不需要权限
        web.ignoring().antMatchers("/index.html", "/static/**", "/favicon.ico", "/error", "/login_p");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //配置访问控制
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O object) {
                        object.setSecurityMetadataSource(mySecurityMetadataSource);
                        object.setAccessDecisionManager(myAccessDecisionManager);
                        return object;
                    }
                })
                //配置访问被拒绝后的处理
                .and().exceptionHandling().accessDeniedHandler(myAccessDeniedHandler)
                //配置登录入口
//                .and().formLogin().loginPage("/login_p").loginProcessingUrl("/login").permitAll()
                .and().formLogin().permitAll()
                //配置登出入口
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login").permitAll()
                .and().csrf().disable();
    }
}
