package com.henucg.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author chenge
 * @Description TODO
 * @Date 2021/2/15 11:43
 */
@Controller
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    /**
     * @Description
     * @Param []
     * @return java.lang.String
     **/
    @RequestMapping(value = "/payment/getServerPort",method = RequestMethod.GET)
    @ResponseBody
    public String getServerPort(){
        return "payment:" + serverPort;
    }
}
