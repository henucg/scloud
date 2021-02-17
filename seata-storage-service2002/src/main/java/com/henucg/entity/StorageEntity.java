package com.henucg.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author chenge
 * @Description TODO
 * @Date 2021/2/17 19:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StorageEntity {

    private Long id;

    //产品ID
    private Long productId;

    //总库存
    private Integer total;

    //已用库存
    private Integer used;

    //剩余库存
    private Integer residue;
}
