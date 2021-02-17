package com.henucg.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author chenge
 * @Description TODO
 * @Date 2021/2/12 20:58
 */
@Configuration
public class ApplicationContextConfig {

    /**
     * @Description  在Application中定义了RibbonClient的规则，
     * 所以此处是否定义@LoadBalanced都不影响
     * @Param []
     * @return org.springframework.web.client.RestTemplate
     **/
    @Bean
    //@LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
