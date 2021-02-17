package com.henucg.filter;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import java.net.URI;

/**
 * @Author chenge
 * @Description TODO
 * @Date 2021/2/13 21:21
 */
@Component
public class MyGatewayFilter implements GlobalFilter, Ordered {
    /**
     * @Description  具体过滤规则
     * @Param [exchange, chain]
     * @return reactor.core.publisher.Mono<java.lang.Void>
     **/
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        URI uri = exchange.getRequest().getURI();
        if("/payment/get".equals(uri.getPath())){
            String id = exchange.getRequest().getQueryParams().getFirst("id");
            if(StringUtils.isEmpty(id)){
                // 当请求"/payment/get"的时候，如果没有参数"id"，过滤器过滤掉
                exchange.getResponse().setStatusCode(HttpStatus.BAD_REQUEST);
                return exchange.getResponse().setComplete();
            }
        }
        return chain.filter(exchange);
    }

    /**
     * @Description  过滤器执行顺序
     * @Param []
     * @return int
     **/
    @Override
    public int getOrder() {
        return 0;
    }
}
