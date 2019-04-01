package com.lee.study.security.security;

import com.lee.study.security.dao.ResourceResposity;
import com.lee.study.security.dao.RoleResourceResposity;
import com.lee.study.security.dao.RoleResposity;
import com.lee.study.security.entity.Resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName MyFilterSecurityMetadataSource
 * @Description 路径拦截处理类
 * @Auth JussiLee
 * @Date 2019/3/27 16:49
 */
@Component
public class MyFilterSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private RoleResourceResposity roleResourceResposity;

    @Autowired
    private ResourceResposity resourceResposity;

    @Autowired
    private RoleResposity roleResposity;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        //获取当前请求的对象
        FilterInvocation fi = (FilterInvocation) o;
        if(isOkAllowedRequest(fi)) return null;
        //获取访问的路径
        String url = fi.getRequestUrl();
        Collection<ConfigAttribute> attributes = getMatcherConfigAttribute(url);
        return attributes;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }

    /*
    根据路径查询所符合的ConfigAttribute
     */
    public Collection<ConfigAttribute> getMatcherConfigAttribute(String url) {
        Resources resources = resourceResposity.findByUrl(url);
        if(resources == null){
            System.out.println(url +"===================");
        }
        return roleResourceResposity.
                findByResoucesid(resources.getId()).stream().
                map( roles ->
                        new SecurityConfig(roleResposity.findById(roles.getRoleid()).get().getName())).
                                collect(Collectors.toList());
    }


    /**
     * 定义允许请求的列表
     * @return
     */
    private List<String> allowedRequest() {
        return Arrays.asList("/login","/","/*.ico","/dist/**","/bower_components/**","/images/**","/js/**","/page/**","/plugins/**","/ztree/**","/include/**");
    }

    /**
     * 判断当前请求是否在允许的范围内
     * @param fi
     * @return
     */
    private boolean isOkAllowedRequest(FilterInvocation fi){
        return  allowedRequest().stream().map(AntPathRequestMatcher :: new).filter(requestMatcher -> requestMatcher.matches(fi.getHttpRequest())).toArray().length > 0;
    }
}
