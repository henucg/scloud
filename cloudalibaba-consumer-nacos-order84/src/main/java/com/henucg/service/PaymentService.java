package com.henucg.service;

import com.henucg.service.impl.PaymentFallbackServiceImpl;
import com.henucg.vo.CommonResult;
import com.henucg.vo.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(value = "cloudalibaba-provider-payment-service", fallback = PaymentFallbackServiceImpl.class)
@Service
public interface PaymentService {
    @RequestMapping(value = "/payment/get/{id}",method = RequestMethod.GET)
    @ResponseBody
    CommonResult<Payment> PaymentSQL(@PathVariable("id") Long id);
}
