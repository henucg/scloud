package com.henucg.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageDao {
    int decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
