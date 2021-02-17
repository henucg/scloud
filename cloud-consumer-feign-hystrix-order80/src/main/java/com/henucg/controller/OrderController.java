package com.henucg.controller;

import com.henucg.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author chenge
 * @Description TODO
 * @Date 2021/2/13 15:13
 */
@Controller
@DefaultProperties(defaultFallback = "getTimeoutHandler")   // 全局的降级处理方法
public class OrderController {

    @Autowired
    private PaymentService paymentService;

    @RequestMapping(value = "/order/ok", method = RequestMethod.GET)
    @ResponseBody
    public String getOk(){
        return paymentService.getOk();
    }

    @RequestMapping(value ="/order/timeout", method = RequestMethod.GET)
    @ResponseBody
//    @HystrixCommand(fallbackMethod = "getTimeoutHandler", commandProperties = {
//            // 设置超时时间为3秒，超过3秒或者出现异常（抛出Exception）进行降级处理
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="2000")
//    })
    @HystrixCommand //此处没有指定自己的降级方法，默认走全局的降级处理方法
    public String getTimeout(){
        return paymentService.getTimeout();
    }

     public String getTimeoutHandler(){
        return "80 繁忙，请等待";
     }
}
