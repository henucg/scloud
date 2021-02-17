package com.henucg.service;

import com.henucg.entity.PaymentEntity;
import com.henucg.vo.PaymentAddVo;

public interface PaymentService {

    void add(PaymentAddVo vo);

    PaymentEntity get(Long id);
}
