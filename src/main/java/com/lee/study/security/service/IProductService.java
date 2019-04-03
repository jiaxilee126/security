package com.lee.study.security.service;

import com.lee.study.security.entity.ProductInfo;
import com.lee.study.security.result.JsonResult;

import java.util.List;

/**
 * @ClassName IProductService
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/4/3 9:01
 */
public interface IProductService {
    List<ProductInfo> getList();
}
