package com.lee.study.security.service.impl;

import com.lee.study.security.dao.ProductInfoResposity;
import com.lee.study.security.entity.ProductInfo;
import com.lee.study.security.result.JsonResult;
import com.lee.study.security.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ProductService
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/4/3 14:29
 */
@Service
@Slf4j
public class ProductService implements IProductService {
    @Autowired
    private ProductInfoResposity productInfoResposity;

    @Override
    public List<ProductInfo> getList() {
        return productInfoResposity.findAll();
    }
}
