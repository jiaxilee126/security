package com.lee.study.security.security;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName MyAccessDecisionManager
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/3/27 16:39
 */
@Component
public class MyAccessDecisionManager implements AccessDecisionManager {

   /*
   authentication 可以获取当前用户拥有的角色集合
   configAttribute 路径拦截中查询到当前路径所需要的角色集合
    */
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> configAttribute) throws AccessDeniedException, InsufficientAuthenticationException {
        if(authentication == null)
            throw new AccessDeniedException("没有权限");

        //当前用户拥有的角色集合
        List<String> rolesName = authentication.getAuthorities().stream().map(GrantedAuthority :: getAuthority).collect(Collectors.toList());

        List<String> urlRoles = configAttribute.stream().map(ConfigAttribute :: getAttribute).collect(Collectors.toList());

        for (String role : rolesName){

            if(urlRoles.contains(role))
                return;
        }
        throw  new AccessDeniedException("没有权限");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return false;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
