package com.henucg.service.impl;

import com.henucg.dao.OrderDao;
import com.henucg.entity.OrderEntity;
import com.henucg.service.AccountService;
import com.henucg.service.OrderService;
import com.henucg.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author chenge
 * @Description TODO
 * @Date 2021/2/17 19:22
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private AccountService accountService;

    @Autowired
    private StorageService storageService;

    @Override
    @GlobalTransactional(name = "fsp-create-order", rollbackFor = Exception.class)//出了异常，回滚所有
    public void create(OrderEntity order) {
        log.info("------------->开始新建订单");
        orderDao.create(order);

        log.info("------------->订单微服务开始调用库存,做扣减 数量");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("------------->订单微服务开始调用库存,做扣减end");

        log.info("------------->订单微服务开始调用账户,做扣减 账户余额");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("------------->订单微服务开始调用账户,做扣减end");

        log.info("------------->修改订单状态开始");
        orderDao.update(order.getUserId(), 0);
        log.info("------------->修改订单状态结束");

        log.info("------------->下订单结束了,O(∩_∩)O哈哈~");
    }
}
