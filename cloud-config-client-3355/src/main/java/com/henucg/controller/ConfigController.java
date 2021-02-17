package com.henucg.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author chenge
 * @Description TODO
 * @Date 2021/2/14 12:05
 */
@Controller
@RefreshScope
public class ConfigController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${config.info}")
    private String configInfo;

    /**
     * @Description  获取配置文件信息
     * @Param []
     * @return java.lang.String
     **/
    @RequestMapping(value = "/config/info", method = RequestMethod.GET)
    @ResponseBody
    public String getConfigInfo(){
        return serverPort + "：" + configInfo;
    }
}
