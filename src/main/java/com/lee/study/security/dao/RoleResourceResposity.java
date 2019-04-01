package com.lee.study.security.dao;

import com.lee.study.security.entity.Roleresources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoleResourceResposity extends JpaRepository<Roleresources, Integer> {

    @Query(value = "select * from roleresources where resourcesid = :resourcesid", nativeQuery = true)
    List<Roleresources> findByResoucesid(@Param("resourcesid") Integer resourcesid);
}
