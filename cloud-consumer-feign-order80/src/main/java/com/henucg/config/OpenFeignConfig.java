package com.henucg.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author chenge
 * @Description TODO
 * @Date 2021/2/13 11:13
 */
@Configuration
public class OpenFeignConfig {

    /**
     * @Description  定义OpenFeign的日志打印级别
     * @Param []
     * @return feign.Logger.Level
     **/
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
