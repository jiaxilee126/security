package com.lee.study.security.service.impl;

import com.lee.study.security.dao.RecruitResposity;
import com.lee.study.security.service.IRecruitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName RecruitService
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/4/3 14:31
 */
@Service
@Slf4j
public class RecruitService implements IRecruitService {
    @Autowired
    private RecruitResposity recruitResposity;
    @Override
    public List getList() {
        return recruitResposity.findAll();
    }
}
