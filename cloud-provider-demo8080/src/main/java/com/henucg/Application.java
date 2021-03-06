package com.henucg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author chenge
 * @Description TODO
 * @Date 2021/2/10 17:36
 */
@SpringBootApplication
@MapperScan("com.henucg.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
