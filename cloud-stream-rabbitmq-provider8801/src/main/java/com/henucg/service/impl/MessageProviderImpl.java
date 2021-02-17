package com.henucg.service.impl;

import com.henucg.service.IMessageProvider;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;

import java.util.UUID;

/**
 * @Author chenge
 * @Description 像RabbitMQ发送消息
 * 官网案例：官网案例 https://cloud.spring.io/spring-cloud-static/spring-cloud-stream-binder-rabbit/3.0.1.RELEASE/reference/html/spring-cloud-stream-binder-rabbit.html
 * @Date 2021/2/14 19:40
 */
@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider {

    // 消息发送管道
    @Autowired
    private MessageChannel output;

    @Override
    public String send() {
        String uuid = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(uuid).build());
        return uuid;
    }
}
