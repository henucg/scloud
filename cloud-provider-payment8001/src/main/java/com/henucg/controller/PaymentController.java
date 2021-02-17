package com.henucg.controller;

import com.henucg.entity.PaymentEntity;
import com.henucg.service.PaymentService;
import com.henucg.vo.CommonResult;
import com.henucg.vo.PaymentAddVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author chenge
 * @Description TODO
 * @Date 2021/2/10 18:20
 */
@Controller
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private PaymentService paymentService;

    /**
     * @Description  新增
     * @Param [vo]
     * @return com.henucg.vo.CommonResult
     **/
    @RequestMapping(value = "/payment/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody PaymentAddVo vo){
        CommonResult result = new CommonResult<String>();
        try {
            paymentService.add(vo);

            result.setCode(0);
            result.setMsg("success");
        } catch (Exception e) {
            log.error(e.getMessage());
            result.setCode(-1);
            result.setMsg("error");
        }
        return result;
    }

    /**
     * @Description  查询
     * @Param [id]
     * @return com.henucg.vo.CommonResult
     **/
    @RequestMapping(value = "/payment/get", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult get(@RequestParam Long id){
        System.out.println("当前服务端口号：" + serverPort);

        CommonResult result = new CommonResult<PaymentEntity>();
        result.setCode(0);
        result.setMsg("success");
        result.setData(paymentService.get(id));
        return result;
    }

    /**
     * @Description 测试OpenFeign超时控制
     * @Param []
     * @return java.lang.String
     **/
    @RequestMapping(value = "/payment/timeout")
    @ResponseBody
    public String getServerPort(){

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return serverPort;
    }
}
