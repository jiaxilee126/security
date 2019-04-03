package com.lee.study.security.dao;

import com.lee.study.security.entity.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruitResposity extends JpaRepository<Recruit, Integer> {
}
