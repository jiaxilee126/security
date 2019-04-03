package com.lee.study.security.dao;

import com.lee.study.security.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName ProductInfoResposity
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/4/3 9:12
 */
public interface ProductInfoResposity extends JpaRepository<ProductInfo, Integer>{
}
