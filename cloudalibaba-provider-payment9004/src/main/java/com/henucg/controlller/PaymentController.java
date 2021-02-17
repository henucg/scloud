package com.henucg.controlller;

import com.henucg.vo.CommonResult;
import com.henucg.vo.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * @Author chenge
 * @Description TODO
 * @Date 2021/2/17 11:44
 */
@Controller
public class PaymentController {

    public static HashMap<Long, Payment> hashMap = new HashMap<>();

    /**
     * 模拟数据库,为省事,不写数据库层面
     */
    static {
        hashMap.put(1L, new Payment(1L, "28a8c1e3bc2742d8848569891fb42181"));
        hashMap.put(2L, new Payment(2L, "28a4c1e3bc2742d8848569891fb42181"));
        hashMap.put(3L, new Payment(3L, "28a5c1e3bc2742d8848569891fb42181"));
    }

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/get/{id}")
    @ResponseBody
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        Payment payment = hashMap.get(id);
        CommonResult<Payment> result = new CommonResult<>(200, "from mysql,serverPort: " + serverPort, payment);
        return result;
    }
}
