package com.lee.study.security.dao;

import com.lee.study.security.entity.RoleResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoleResourceResposity extends JpaRepository<RoleResource, Integer> {

    @Query(value = "select * from role_resource where resource_id = :resource_id", nativeQuery = true)
    List<RoleResource> findByResourceId(@Param("resource_id") Integer resourcesid);
}
