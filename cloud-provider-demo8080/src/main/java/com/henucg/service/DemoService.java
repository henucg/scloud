package com.henucg.service;

import com.henucg.entity.DemoEntity;
import com.henucg.vo.DemoAddVo;

public interface DemoService {

    void add(DemoAddVo vo);

    DemoEntity get(Long id);
}
