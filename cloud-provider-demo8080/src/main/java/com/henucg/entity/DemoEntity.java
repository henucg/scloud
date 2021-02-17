package com.henucg.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author chenge
 * @Description TODO
 * @Date 2021/2/10 21:31
 */
@Data
@TableName("t_demo")
public class DemoEntity {

    private Long id;
    private String serial;
}
