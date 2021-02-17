package com.henucg.controller;

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

import java.util.List;

/**
 * @Author chenge
 * @Description TODO
 * @Date 2021/2/11 10:51
 */
@Controller
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * @Description  请求payment服务
     * @Param [id]
     * @return com.henucg.vo.CommonResult
     **/
    @RequestMapping(value = "/order/get", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult get(@RequestParam Long id){
        CommonResult commonResult = new CommonResult();

        // 多个服务注册到eureka之后，不再根据IP+PORT寻找服务地址，而是根据名称（同时再配置文件里面添加负载均衡策略）
        // String requestUrl = "http://localhost:8001/payment/get?id=1359486447825227778";
        String requestUrl = "http://cloud-payment-service/payment/get?id="+id;

        commonResult = restTemplate.getForObject(requestUrl,CommonResult.class);

        return commonResult;
    }

    /**
     * @Description  查询eureka所有注册的服务
     * @Param []
     * @return com.henucg.vo.CommonResult
     **/
    @ResponseBody
    @RequestMapping(value = "/get/discovery", method = RequestMethod.GET)
    public CommonResult getDiscovery(){
        CommonResult<List<String>> commonResult = new CommonResult();

        List<String> servies = discoveryClient.getServices();
        commonResult.setData(servies);

        return commonResult;
    }

    /**
     * @Description  根据serverId查询服务的所有实例
     * @Param [serverName]
     * @return com.henucg.vo.CommonResult
     **/
    @ResponseBody
    @RequestMapping(value = "/get/instance", method = RequestMethod.GET)
     public CommonResult getInstanceByServerName(@RequestParam String serverName){
         CommonResult<List<ServiceInstance>> commonResult = new CommonResult();

         List<ServiceInstance> instances = discoveryClient.getInstances(serverName);
         commonResult.setData(instances);

         return commonResult;
     }
}
