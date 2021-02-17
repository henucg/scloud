package com.henucg.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author chenge
 * @Description 路由规则除了可以通过yml文件配置之外，还可以通过编码方式实现
 * @Date 2021/2/13 20:28
 */
@Configuration
public class GateConfig {

    /**
     * @Description  请求：http://localhost:9527/guonei
     * 跳转到：https://news.baidu.com/guonei
     * @Param [routeLocatorBuilder]
     * @return org.springframework.cloud.gateway.route.RouteLocator
     **/
    @Bean
    public RouteLocator customerRouteLocatorGuonei(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder.routes()
                .route("baidu_news_guonei",r->r.path("/guonei").uri("https://news.baidu.com/guonei"))
                .build();
    }

    /**
     * @Description  请求：http://localhost:9527/guoji
     * 跳转到：https://news.baidu.com/guoji
     * @Param [routeLocatorBuilder]
     * @return org.springframework.cloud.gateway.route.RouteLocator
     **/
    @Bean
    public RouteLocator customerRouteLocatorGuoji(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder.routes()
                .route("baidu_news_guoji",r->r.path("/guoji").uri("https://news.baidu.com/guoji"))
                .build();
    }
}
