package com.henucg.service;

import com.henucg.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

@FeignClient(value = "seata-account-service")
public interface AccountService {

    @RequestMapping(value = "/account/decrease",method = RequestMethod.GET)
    @ResponseBody
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
