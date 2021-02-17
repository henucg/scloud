package com.henucg.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.henucg.entity.PaymentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMapper extends BaseMapper<PaymentEntity> {
}
