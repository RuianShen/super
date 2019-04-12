package com.service.impl;

import com.dao.OperatorDao;
import com.entity.OperatorEntity;
import com.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by LXP on 2018/1/8.
 */
@Service
public class TestServiceImpl implements TestService {
    @Resource
    private OperatorDao operatorDao;

    @Override
    public int insertSelective(OperatorEntity record) {
        return operatorDao.insertSelective(record);
    }
}
