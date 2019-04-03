package com.lee.study.security.security;


import com.lee.study.security.dao.AdminResposity;
import com.lee.study.security.dao.RoleResposity;
import com.lee.study.security.dao.AdminRoleResposity;
import com.lee.study.security.entity.Admin;
import com.lee.study.security.entity.AdminRole;
import com.lee.study.security.entity.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * @ClassName MyUserDetailsService
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/3/27 10:58
 */
@Slf4j
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private AdminResposity adminResposity;

    @Autowired
    private AdminRoleResposity adminRoleResposity;

    @Autowired
    private RoleResposity roleResposity;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(StringUtils.isEmpty(username)) {
            log.error("{} 用户名不存在", username);
            throw  new UsernameNotFoundException("用户名不存在");
        }

        //数据库查出来用户
        Admin admin = adminResposity.findByName(username);
        //权限赋值
        Set<GrantedAuthority> authorities = new HashSet<>();

        List<AdminRole> adminRoles = adminRoleResposity.findByAdminId(admin.getId());

        adminRoles.forEach(e -> {
            Optional optional = roleResposity.findById(e.getRoleId());
            Role role = (Role) optional.get();
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });


        return new org.springframework.security.core.userdetails.User(admin.getUsername(), admin.getPassword(), authorities);
    }
}
