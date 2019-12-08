package com.xmu.oomall.dao;

import com.xmu.oomall.domain.Goods;
import com.xmu.oomall.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class GoodsDao {
    @Autowired
    private GoodsMapper goodsMapper;

    public Goods findGoodsById(Integer id){
        return goodsMapper.findGoodsById(id);
    }
}
