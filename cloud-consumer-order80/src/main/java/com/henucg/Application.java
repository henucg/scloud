package com.henucg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author chenge
 * @Description TODO
 * EnableDiscoveryClient :服务发现作用，可以拿到eureka所有的注册服务信息
 * @Date 2021/2/11 10:50
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
