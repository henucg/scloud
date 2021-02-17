package com.henucg.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.henucg.handler.CustomerBlockHandler;
import com.henucg.vo.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author chenge
 * @Description TODO
 * @Date 2021/2/15 20:07
 */
@Controller
public class TestController {

    @Value("${server.port}")
    private String serverPort;

    /**
     * @Description  测试QPS限流
     * @Param []
     * @return java.lang.String
     **/
    @RequestMapping(value = "/test/a",method = RequestMethod.GET)
    @ResponseBody
    public String getA(){
        return serverPort + "-testA";
    }

    /**
     * @Description  测试线程数限流
     * @Param []
     * @return java.lang.String
     **/
    @RequestMapping(value = "/test/b",method = RequestMethod.GET)
    @ResponseBody
    public String getB(){
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return serverPort + "-testB";
    }
    
    /**
     * @Description  
     * @Param []
     * @return java.lang.String
     **/
    @RequestMapping(value = "/test/c")
    @ResponseBody
    public String getC(){
        return serverPort + "-testC";
    }

    /**
     * @Description 测试异常比例/异常数
     * @Param []
     * @return java.lang.String
     **/
    @RequestMapping(value = "/test/d")
    @ResponseBody
    public String getD(){
        int a = 10/0;
        return serverPort + "-testD";
    }

    /**
     * @Description  测试热点Key限流
     * @Param [p1, p2]
     * @return java.lang.String
     **/
    @RequestMapping(value = "/test/hotKey",method = RequestMethod.GET)
    @SentinelResource(value = "testHotKey",blockHandler = "dealHandler_hotKey")   // 热点规则需要配置的key
    @ResponseBody
    public String getE(@RequestParam(value = "p1",required = false) String p1,
                       @RequestParam(value = "p2",required = false) String p2){
        return "success";
    }

    public String dealHandler_hotKey(String p1, String p2, BlockException e){
        return "error";
    }

    /**
     * @Description  测试全局fallback方法
     * SentinelResource 不支持private方法
     * @Param []
     * @return java.lang.String
     **/
    @RequestMapping(value = "/test/f",method = RequestMethod.GET)
    @ResponseBody
    @SentinelResource(
            value = "testF",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException")
    public CommonResult getF(){
        return new CommonResult(200,serverPort + "-testF");
    }
}
