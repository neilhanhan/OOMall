package com.xmu.oomall.mapper;

import com.xmu.oomall.domain.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface GoodsMapper {
    /**
     * 根据商品id查询商品
     * @param id
     * @return
     */
    Goods findGoodsById(Integer id);
}
