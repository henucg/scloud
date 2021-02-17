package com.henucg.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author chenge
 * @Description TODO
 * @Date 2021/2/17 19:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {

    private Long id;
    private Long userId;
    private long productId;
    private Integer count;
    private BigDecimal money;
    /**
     * //订单状态:  0:创建    1:已完成
     */
    private Integer status;
}
