package com.henucg.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @Author chenge
 * @Description TODO
 * @Date 2021/2/14 20:35
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveListener {

    @Value("${server.port}")
    private String serverPort;

    /**
     * @Description  监听消息
     * @Param [message]
     * @return void
     **/
    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("-------->消费者：" + serverPort + "，接受到消息：" + message.getPayload());
    }
}
