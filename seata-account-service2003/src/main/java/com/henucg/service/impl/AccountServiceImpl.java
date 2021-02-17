package com.henucg.service.impl;

import com.henucg.dao.AccountDao;
import com.henucg.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @Author chenge
 * @Description TODO
 * @Date 2021/2/17 20:20
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("------------->account-service 中扣减库存开始");
        //  模拟异常 配合 2001 服务里面的注解    @GlobalTransactional(name = "fsp-create-order", rollbackFor = Exception.class)
        //  导致结果,订单状态没变成已完成,库存和账户都被扣减
        //  正常测试注销try catch.
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountDao.decrease(userId, money);
        log.info("------------->account-service 中扣减库存结束");
    }
}
