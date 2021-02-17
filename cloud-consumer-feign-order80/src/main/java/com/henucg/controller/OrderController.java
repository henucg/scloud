package com.henucg.controller;

import com.henucg.service.PaymentService;
import com.henucg.vo.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author chenge
 * @Description TODO
 * @Date 2021/2/13 10:04
 */
@Controller
public class OrderController {

    @Autowired
    private PaymentService paymentService;

    /**
     * @Description feign调用远程服务
     * @Param [id]
     * @return com.henucg.vo.CommonResult
     **/
    @RequestMapping(value = "/order/get", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult get(@RequestParam Long id){
        return paymentService.get(id);
    }

    /**
     * @Description  测试OpenFeign超时处理
     * @Param []
     * @return java.lang.String
     **/
    @RequestMapping(value = "/order/timeout")
    @ResponseBody
    public String getServerPort(){
        return paymentService.getServerPort();
    }
}
