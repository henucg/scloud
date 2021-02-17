package com.henucg.loadbalance.impl;

import com.henucg.loadbalance.MyLoadbalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author chenge
 * @Description TODO
 * @Date 2021/2/12 21:52
 */
@Service
public class MyLoadbalancerImpl implements MyLoadbalancer {
    // 统计请求次数
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = this.getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }

    /**
     * @Description 获取轮训次数
     * @Param []
     * @return int
     **/
    private int getAndIncrement(){
        int curr = 0;
        int next = 0;
        do {
            curr = this.atomicInteger.get();
            next = curr >= Integer.MAX_VALUE ? 0 : curr + 1 ;
        } while(!this.atomicInteger.compareAndSet(curr,next));
        return next;
    }
}
