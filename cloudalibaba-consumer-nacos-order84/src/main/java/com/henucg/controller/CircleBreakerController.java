package com.henucg.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.henucg.service.PaymentService;
import com.henucg.vo.CommonResult;
import com.henucg.vo.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * @Author chenge
 * @Description TODO
 * @Date 2021/2/17 12:09
 */
@Controller
public class CircleBreakerController {

    public static final String SERVICE_URL = "http://cloudalibaba-provider-payment-service";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PaymentService paymentService;

    @RequestMapping(value = "/consumer/fallback/{id}",method = RequestMethod.GET)
    @ResponseBody
//    @SentinelResource(value = "fallback") //没有配置
//    @SentinelResource(value = "fallback", fallback = "handlerFallback")   //fallback 只负责业务异常
//    @SentinelResource(value = "fallback", blockHandler = "blockHandler")    //blockHandler只负责sentinel控制台配置违规
//    @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockHandler")  //fallback和blockHandler 都配置
    @SentinelResource(value = "fallback",
            fallback = "handlerFallback",
            blockHandler = "blockHandler",
            exceptionsToIgnore = {IllegalArgumentException.class}
    )//fallback和blockHandler 都配置
    public CommonResult<Payment> fallback(@PathVariable("id") Long id) {

        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/payment/get/" + id, CommonResult.class, id);

        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException,该ID没有对应记录，空指针异常");
        }
        return result;
    }

    /**
     * 本例子是 fallback handlerFallback
     *
     * @param id
     * @param e
     * @return
     */
    public CommonResult handlerFallback(@PathVariable("id") Long id, Throwable e) {
        Payment payment = new Payment(id, "null");
        return new CommonResult(444, "兜底异常handlerFallback，exception内容" + e.getMessage(), payment);
    }

//--------------------------------- OpenFeign ---------------------------------

    /**
     * 本例子是 blockHandler
     *
     * @param id
     * @param blockException
     * @return
     */
    public CommonResult blockHandler(@PathVariable("id") Long id, BlockException blockException) {
        Payment payment = new Payment(id, "null");
        return new CommonResult(445, "blockHandler-sentinel限流，无此流水：blockException" + blockException.getClass().getCanonicalName(), payment);
    }

    @RequestMapping(value = "/consumer/payment/{id}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        return paymentService.PaymentSQL(id);
    }
}
