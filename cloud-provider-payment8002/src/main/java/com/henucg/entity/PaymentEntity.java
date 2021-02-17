package com.henucg.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author chenge
 * @Description TODO
 * @Date 2021/2/10 17:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_payment")
public class PaymentEntity {
    /**
     * @Description  主键
     * @Param
     * @return
     **/
    private Long id;

    /**
     * @Description  序列号
     * @Param
     * @return
     **/
    private String serial;
}
