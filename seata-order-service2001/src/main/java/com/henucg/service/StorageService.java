package com.henucg.service;

import com.henucg.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(value = "seata-storage-service")
public interface StorageService {

    @RequestMapping(value = "/storage/decrease",method = RequestMethod.GET)
    @ResponseBody
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
