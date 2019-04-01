package com.lee.study.security.dao;

import com.lee.study.security.SecurityApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class RoleResourceResposityTest extends SecurityApplicationTests{
    @Autowired
    private RoleResourceResposity roleResourceResposity;
    @Test
    public void findByResoucesid() throws Exception {
        System.out.println(roleResourceResposity.findByResoucesid(4));
    }

}