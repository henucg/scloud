package com.henucg.controller;

import com.henucg.entity.DemoEntity;
import com.henucg.service.DemoService;
import com.henucg.vo.CommonResult;
import com.henucg.vo.DemoAddVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author chenge
 * @Description TODO
 * @Date 2021/2/10 18:20
 */
@Controller
@Slf4j
public class DemoController {

    @Autowired
    private DemoService demoService;

    /**
     * @Description  新增
     * @Param [vo]
     * @return com.henucg.vo.CommonResult
     **/
    @RequestMapping(value = "/demo/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody DemoAddVo vo){
        CommonResult result = new CommonResult<String>();
        try {
            demoService.add(vo);

            result.setCode(0);
            result.setMsg("success");
        } catch (Exception e) {
            log.error(e.getMessage());
            result.setCode(-1);
            result.setMsg("error");
        }
        return result;
    }

    /**
     * @Description  查询
     * @Param [id]
     * @return com.henucg.vo.CommonResult
     **/
    @RequestMapping(value = "/demo/get", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult get(@RequestParam Long id){
        CommonResult result = new CommonResult<DemoEntity>();
        result.setCode(0);
        result.setMsg("success");
        result.setData(demoService.get(id));
        return result;
    }
}
