package com.henucg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Author chenge
 * @Description TODO
 * @Date 2021/2/13 17:31
 */
@SpringBootApplication
@EnableHystrixDashboard
public class Application {

    /**
     * @Description  监控服务，在配置了HystrixDashBoard监控的服务之后，
     * 进入到DashBoard的监控页面：http://localhost:9001/hystrix
     * 输入框输入需要监控的服务：http://localhost:8001/hystrix.stream
     * 即可查询被监控服务的请求情况
     * @Param [args]
     * @return void
     **/
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
