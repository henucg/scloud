package com.henucg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * @Author chenge
 * @Description TODO
 * @Date 2021/2/12 18:11
 */
@Controller
public class OrderController {

    private static final String REST_URL = "http://cloud-provider-payment" ;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * @Description  请求zookeeper获取服务端调用
     * 注册进入Zookeeper之后，如果Zookeeper停掉之后，服务依然能用，只是心跳的时候链接不上
     * @Param []
     * @return java.lang.String
     **/
    @RequestMapping(value = "/order/get", method = RequestMethod.GET)
    @ResponseBody
    public String get(){
        return restTemplate.getForObject(REST_URL+"/payment/get",String.class);
    }
}
