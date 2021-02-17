package com.henucg.service;

import com.henucg.vo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentService {

    @RequestMapping(value = "/payment/get",method = RequestMethod.GET)
    @ResponseBody
    CommonResult get(@RequestParam("id") Long id);

    @RequestMapping(value = "/payment/timeout",method = RequestMethod.GET)
    @ResponseBody
    String getServerPort();
}
