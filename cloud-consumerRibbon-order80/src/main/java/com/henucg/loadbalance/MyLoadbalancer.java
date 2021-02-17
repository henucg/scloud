package com.henucg.loadbalance;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface MyLoadbalancer {

    /**
     * @Description  自定义负载均衡算法拿实例服务
     * @Param [list]
     * @return org.springframework.cloud.client.ServiceInstance
     **/
    ServiceInstance instances(List<ServiceInstance> list);
}
