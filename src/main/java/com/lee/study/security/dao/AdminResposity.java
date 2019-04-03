package com.lee.study.security.dao;

import com.lee.study.security.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @ClassName AdminResposity
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/3/27 11:19
 */
public interface AdminResposity extends JpaRepository<Admin, Integer> {

    @Query(value = "select * from admin where username = :username", nativeQuery = true)
    Admin findByName(@Param("username") String username);

}
