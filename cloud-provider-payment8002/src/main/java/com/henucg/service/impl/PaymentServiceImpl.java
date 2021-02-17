package com.henucg.service.impl;

import com.henucg.entity.PaymentEntity;
import com.henucg.mapper.PaymentMapper;
import com.henucg.service.PaymentService;
import com.henucg.vo.PaymentAddVo;
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
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public void add(PaymentAddVo vo){
        PaymentEntity entity = new PaymentEntity();
        entity.setSerial(vo.getSerial());
        paymentMapper.insert(entity);
    }

    @Override
    public PaymentEntity get(Long id) {
        return paymentMapper.selectById(id);
    }
}
