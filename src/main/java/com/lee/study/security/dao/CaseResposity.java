package com.lee.study.security.dao;

import com.lee.study.security.entity.ProductCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaseResposity extends JpaRepository<ProductCase, Integer> {
}
