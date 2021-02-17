package com.henucg.controller;

import com.henucg.entity.CommonResult;
import com.henucg.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author chenge
 * @Description TODO
 * @Date 2021/2/17 20:02
 */
@Controller
public class StorageController {

    @Autowired
    private StorageService storageService;

    @RequestMapping(value = "/storage/decrease",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult decrease(@RequestParam("productId") Long productId,
                                 @RequestParam("count") Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult(200, "扣减库存成功");
    }
}
