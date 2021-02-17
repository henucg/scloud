package com.henucg.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author chenge
 * @Description TODO
 * @Date 2021/2/12 18:09
 */
@Configuration
public class ApplicationContextConfig {

    /**
     * @Description
     *  必须配置@LoadBalanced，否则会出现
     *  nested exception is java.net.UnknownHostException: cloud-provider-payment] with root cause
     * java
     * @Param []
     * @return org.springframework.web.client.RestTemplate
     **/
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
