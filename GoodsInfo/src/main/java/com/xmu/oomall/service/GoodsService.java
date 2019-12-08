package com.xmu.oomall.service;

import com.xmu.oomall.dao.GoodsDao;
import com.xmu.oomall.domain.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsService {
    @Autowired
    private GoodsDao goodsDao;

    public Goods findGoodsById(Integer id){
        return goodsDao.findGoodsById(id);
    }
}
