package com.henucg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author chenge
 * @Description TODO
 * @Date 2021/2/13 15:00
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
