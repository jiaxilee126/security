package com.lee.study.security.dao;

import com.lee.study.security.entity.Resources;
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
public interface ResourceResposity extends JpaRepository<Resources , Integer> {

    @Query(value = "select * from resources where url = :url", nativeQuery = true)
    Resources findByUrl(@Param("url")String url);

    @Query(value = "Select * from resources where type = :type", nativeQuery = true)
    List<Resources> findByType(@Param("type") Integer type);

    @Query(value = "select * from resources where parentid = :parentid", nativeQuery = true)
    List<Resources> getSubResouces(@Param("parentid") Integer parentid);
}
