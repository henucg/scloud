package com.henucg.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.henucg.vo.CommonResult;

/**
 * @Author chenge
 * @Description TODO
 * @Date 2021/2/17 11:11
 */
public class CustomerBlockHandler {

    /**
     * @Description  全局异常（降级、限流）处理
     * 方法必须是static的
     * @Param [e]
     * @return com.henucg.vo.CommonResult
     **/
    public static CommonResult handlerException(BlockException e){
        return new CommonResult(500,"异常");
    }
}
