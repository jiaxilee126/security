package com.lee.study.security.service.impl;

import com.lee.study.security.dao.CaseResposity;
import com.lee.study.security.entity.ProductCase;
import com.lee.study.security.result.JsonResult;
import com.lee.study.security.service.ICaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CaseService
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/4/3 9:02
 */
@Service
@Slf4j
public class CaseService implements ICaseService {

    @Autowired
    private CaseResposity caseResposity;

    @Override
    public List<ProductCase> getList() {
        List<ProductCase> cases = caseResposity.findAll(Sort.by(Sort.Direction.DESC, "id"));
        return cases;
    }
}
