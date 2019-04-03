package com.lee.study.security.dao;

import com.lee.study.security.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @ClassName ResourceResposity
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/3/27 17:08
 */
public interface ResourceResposity extends JpaRepository<Resource, Integer> {

    @Query(value = "select * from resource where url = :url", nativeQuery = true)
    Resource findByUrl(@Param("url")String url);

    @Query(value = "Select * from resource where type = :type", nativeQuery = true)
    List<Resource> findByType(@Param("type") Integer type);

    @Query(value = "select * from resource where parent_id = :parent_id", nativeQuery = true)
    List<Resource> getSubResouces(@Param("parent_id") Integer parentid);
}
