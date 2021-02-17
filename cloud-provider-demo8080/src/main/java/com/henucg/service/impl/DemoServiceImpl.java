package com.henucg.service.impl;

import com.henucg.entity.DemoEntity;
import com.henucg.mapper.DemoMapper;
import com.henucg.service.DemoService;
import com.henucg.vo.DemoAddVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author chenge
 * @Description TODO
 * @Date 2021/2/10 18:17
 */
@Service
@Slf4j
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoMapper demoMapper;

    @Override
    public void add(DemoAddVo vo){
        DemoEntity entity = new DemoEntity();
        entity.setSerial(vo.getSerial());
        demoMapper.insert(entity);
    }

    @Override
    public DemoEntity get(Long id) {
        return demoMapper.selectById(id);
    }
}
