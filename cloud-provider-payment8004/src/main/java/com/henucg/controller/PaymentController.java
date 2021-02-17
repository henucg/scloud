package com.henucg.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

/**
 * @Author chenge
 * @Description TODO
 * @Date 2021/2/12 17:59
 */
@Controller
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    /**
     * @Description 测试注入Zookeeper
     * @Param []
     * @return java.lang.String
     **/
    @RequestMapping(value = "/payment/get", method = RequestMethod.GET)
    @ResponseBody
    public String get(){
        return "服务端口号：" + serverPort + "，UUID：" + UUID.randomUUID();
    }
}
