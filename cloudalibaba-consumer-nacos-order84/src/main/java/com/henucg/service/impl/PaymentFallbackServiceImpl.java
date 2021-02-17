package com.henucg.service.impl;

import com.henucg.service.PaymentService;
import com.henucg.vo.CommonResult;
import com.henucg.vo.Payment;
import org.springframework.stereotype.Service;

/**
 * @Author chenge
 * @Description TODO
 * @Date 2021/2/17 12:15
 */
@Service
public class PaymentFallbackServiceImpl implements PaymentService {
    @Override
    public CommonResult<Payment> PaymentSQL(Long id) {
        return new CommonResult<>(444444444, "服务降级返回，----PaymentFallbackServiceImpl", new Payment(id, "errorSerial"));
    }
}
