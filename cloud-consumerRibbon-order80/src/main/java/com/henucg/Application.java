package com.henucg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import spring.clould.rule.MySelfRule;

/**
 * @Author chenge
 * @Description
 *  注解@RibbonClient测试自定义IRule的时候放开
 *  测试自定义负载均衡算法的时候注释掉
 * @Date 2021/2/12 20:52
 */
@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MySelfRule.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
