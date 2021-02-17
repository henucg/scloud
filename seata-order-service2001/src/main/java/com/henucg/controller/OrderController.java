package com.henucg.controller;

import com.henucg.entity.CommonResult;
import com.henucg.entity.OrderEntity;
import com.henucg.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author chenge
 * @Description TODO
 * @Date 2021/2/17 20:28
 */
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 测试链接
     * http://localhost:2001/order/create?userId=1&productId=1&count=10&money=100
     *
     * @param order
     * @return
     */
    @RequestMapping(value = "/order/create",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult create(OrderEntity order) {
        orderService.create(order);
        return new CommonResult(200, "订单创建完成", order);
    }
}
