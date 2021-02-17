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
 * @Date 2021/2/15 12:33
 */
@Controller
@RefreshScope   //自动刷新，不需要再像Bus/Config那样，需要调用接口手动刷新
public class ConfigController {

    @Value("${config.info}")
    private String configInfo;

    /**
     * @Description 获取8848上的配置信息
     * @Param []
     * @return java.lang.String
     **/
    @RequestMapping(value = "/config/info",method = RequestMethod.GET)
    @ResponseBody
    public String getConfigInfo(){
        return configInfo;
    }

}
