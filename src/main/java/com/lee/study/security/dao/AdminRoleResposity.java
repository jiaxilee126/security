package com.lee.study.security.dao;

import com.lee.study.security.entity.AdminRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @ClassName AdminRoleResposity
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/3/27 11:20
 */
public interface AdminRoleResposity extends JpaRepository<AdminRole, Integer> {

    @Query(name = "Select * from admin_role where admin_id=:admin_id", nativeQuery = true)
    List<AdminRole> findByAdminId(@Param("admin_id") Integer userid);
}
