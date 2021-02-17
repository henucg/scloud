package com.henucg.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @Author chenge
 * @Description TODO
 * @Date 2021/2/13 13:30
 */
@Controller
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    /**
     * @Description  测试正常服务
     * @Param []
     * @return java.lang.String
     **/
    @RequestMapping(value = "/payment/ok", method = RequestMethod.GET)
    @ResponseBody
    public String getOk(){
        return serverPort + " is OK" ;
    }


    // =====================服务降级====================

    /**
     * @Description 测试服务降级
     * @Param []
     * @return java.lang.String
     **/
    @RequestMapping(value ="/payment/timeout", method = RequestMethod.GET)
    @ResponseBody
    @HystrixCommand(fallbackMethod = "getTimeoutHandler", commandProperties = {
            // 设置超时时间为3秒，超过3秒或者出现异常（（抛出Exception））进行降级处理
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String getTimeout(){

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return serverPort + " is timeout";
    }

    /**
     * @Description  降级处理方法
     * @Param []
     * @return java.lang.String
     **/
    private String getTimeoutHandler(){
        return serverPort + "繁忙，请等待";
    }


    // =====================服务熔断====================

    /**
     * @Description  测试服务熔断（失败->断开->恢复）
     * @Param [id]
     * @return java.lang.String
     **/
    @RequestMapping(value = "/payment/circuit", method = RequestMethod.GET)
    @ResponseBody
    @HystrixCommand(fallbackMethod = "circuitbreakerHandler", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),    // 开启熔断
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),  // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),    // 时间窗口（10秒）
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")    // 失败率达到多少的时候熔断
    })
    public String circuitbreaker(@RequestParam Integer id){
        if(id < 0){
            throw new RuntimeException("id：" + id + "，不能为负数");
        }

        return Thread.currentThread().getName() + " 调用成功，流水号：" + UUID.randomUUID();
    }

    /**
     * @Description  熔断处理方法
     * @Param [id]
     * @return java.lang.String
     **/
    public String circuitbreakerHandler(@RequestParam Integer id){
        return "id 不能负数，请稍后再试，o(╥﹏╥)o id：" + id;
    }
}
