package com.henucg.service;

import org.springframework.stereotype.Service;

/**
 * @Author chenge
 * @Description 客户端开启被调用服务的降级处理，当服务端宕机之后出现
 * @Date 2021/2/13 16:03
 */
@Service
public class PaymentFallbackService implements PaymentService{
    @Override
    public String getOk() {
        return "-------PaymentFallbackService fall back-[paymentInfo_OK],o(╥﹏╥)o";
    }

    @Override
    public String getTimeout() {
        return "-------PaymentFallbackService fall back-[paymentInfo_TimeOut],o(╥﹏╥)o";
    }
}
