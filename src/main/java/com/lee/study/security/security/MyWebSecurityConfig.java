package com.lee.study.security.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName MyWebSecurityConfig
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/3/27 11:01
 */
@Configuration
@EnableWebSecurity
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private MyFilter myFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.
                //所有用户都需要签名之后
                authorizeRequests().
                antMatchers("/bower_components/**","/dist/**","/images/**","/js/**","/page/**","/plugins/**","/ztree/**").permitAll().anyRequest().authenticated().
                //antMatchers("/dist/**").permitAll().anyRequest().authenticated().
                //所有请求必须经过签名
                anyRequest().authenticated().
                //withObjectPostProcessor(myPostProcessor).
                and().formLogin().loginPage("/login").permitAll().successHandler(loginSuccessHandler()).successForwardUrl("/index");
        http.httpBasic();
        //页面嵌入iframe的时候
        http.headers().frameOptions().disable();
        http.addFilterBefore(myFilter, FilterSecurityInterceptor.class);
        //System.out.println(objectPostProcessor);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }



    @Bean
    public SavedRequestAwareAuthenticationSuccessHandler loginSuccessHandler() { //登入处理


        return new SavedRequestAwareAuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                //Admin userDetails = (Admin) authentication.getPrincipal();
                User usr = (User) authentication.getPrincipal();
                logger.info("USER : "+usr.getUsername() +"==" + " LOGIN SUCCESS !  ");
                // response.setStatus(0);
                //response.
                super.onAuthenticationSuccess(request, response, authentication);
            }
        };
    }
}
