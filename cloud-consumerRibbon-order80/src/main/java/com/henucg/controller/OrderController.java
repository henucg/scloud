package com.henucg.controller;

import com.henucg.loadbalance.MyLoadbalancer;
import com.henucg.vo.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @Author chenge
 * @Description TODO
 * @Date 2021/2/12 20:56
 */
@Controller
public class OrderController {

    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private MyLoadbalancer myLoadbalancer;

    /**
     * @Description  测试自定义负载均衡Rule
     * @Param []
     * @return com.henucg.vo.CommonResult
     **/
    @RequestMapping(value = "/order/get",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult get(@RequestParam Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get?id="+id,CommonResult.class);
    }

    /**
     * @Description  测试自定义负载均衡算法
     * @Param [id]
     * @return com.henucg.vo.CommonResult
     **/
    @RequestMapping(value = "/order/getByBalance",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getByLoadbalance(@RequestParam Long id){
        CommonResult commonResult = new CommonResult();

        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(serviceInstances == null || serviceInstances.size()==0){
            return commonResult;
        }

        ServiceInstance serviceInstance = myLoadbalancer.instances(serviceInstances);
        URI uri = serviceInstance.getUri();

        return restTemplate.getForObject(uri+"/payment/get?id="+id,CommonResult.class);
    }
}
