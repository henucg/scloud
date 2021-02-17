package com.henucg.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
@FeignClient(value = "cloud-hystrix-payment-service", fallback = PaymentFallbackService.class)// 客户端开启被调用服务的降级处理，当服务端宕机之后出现
public interface PaymentService {

    @RequestMapping(value = "/payment/ok", method = RequestMethod.GET)
    @ResponseBody
    String getOk();

    @RequestMapping(value ="/payment/timeout", method = RequestMethod.GET)
    @ResponseBody
    String getTimeout();
}
