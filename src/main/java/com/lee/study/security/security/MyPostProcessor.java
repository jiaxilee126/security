package com.lee.study.security.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyPostProcessor后置程序处理对象
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/3/27 16:36
 */

public class MyPostProcessor {
/*
    @Autowired
    private MyAccessDecisionManager myAccessDecisionManager;

    @Autowired
    private MyFilterSecurityMetadataSource myFilterSecurityMetadataSource;
    @Override
    public <T extends FilterSecurityInterceptor> T postProcess(T fsi) {
        fsi.setAccessDecisionManager(myAccessDecisionManager);
        fsi.setSecurityMetadataSource(myFilterSecurityMetadataSource);
        return fsi;
    }*/
}
