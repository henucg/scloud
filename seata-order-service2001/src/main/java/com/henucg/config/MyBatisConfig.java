package com.henucg.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author chenge
 * @Description TODO
 * @Date 2021/2/17 19:16
 */
@Configuration
@MapperScan("com.henucg.dao")
public class MyBatisConfig {
}
