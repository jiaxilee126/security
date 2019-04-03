package com.lee.study.security.service;

import com.lee.study.security.entity.ProductCase;
import com.lee.study.security.result.JsonResult;

import java.util.List;

/**
 * @ClassName ICaseService
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/4/3 9:00
 */
public interface ICaseService {
    List<ProductCase> getList();
}
