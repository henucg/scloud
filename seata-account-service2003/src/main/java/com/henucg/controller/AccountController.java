package com.henucg.controller;

import com.henucg.entity.CommonResult;
import com.henucg.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

/**
 * @Author chenge
 * @Description TODO
 * @Date 2021/2/17 20:21
 */
@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/account/decrease",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult decrease(@RequestParam("userId") Long userId,
                                 @RequestParam("money") BigDecimal money) {
        accountService.decrease(userId, money);
        return new CommonResult(200, "扣减账户余额成功");
    }
}
