package com.henucg.controller;

import com.henucg.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author chenge
 * @Description TODO
 * @Date 2021/2/14 19:49
 */
@Controller
public class MessageController {

    @Autowired
    private IMessageProvider iMessageProvider;

    /**
     * @Description 向RabbitMQ发送消息
     * @Param []
     * @return java.lang.String
     **/
    @RequestMapping(value = "/message/send", method = RequestMethod.GET)
    @ResponseBody
    public String sendMessage(){
        return iMessageProvider.send();
    }
}
