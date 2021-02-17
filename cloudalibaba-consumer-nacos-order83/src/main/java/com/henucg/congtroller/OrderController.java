package com.henucg.congtroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * @Author chenge
 * @Description TODO
 * @Date 2021/2/15 12:04
 */
@Controller
public class OrderController {

    @Value("${server-url.nacos-user-service}")
    private String serviceName;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * @Description  
     * @Param []
     * @return java.lang.String
     **/
    @RequestMapping(value = "/order/get",method = RequestMethod.GET)
    @ResponseBody
    public String getPayment(){
        return restTemplate.getForObject(serviceName+"/payment/getServerPort",String.class);
    }
}
