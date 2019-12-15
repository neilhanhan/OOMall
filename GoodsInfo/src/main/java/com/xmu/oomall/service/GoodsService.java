package com.xmu.oomall.service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.xmu.oomall.dao.GoodsDao;
import com.xmu.oomall.domain.Goods;
import com.xmu.oomall.domain.GoodsPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {
    @Autowired
    private GoodsDao goodsDao;

    public Goods getGoodsById(Integer id){
        return goodsDao.findGoodsById(id);
    }

    public Integer deleteGoodsById(Integer id){return goodsDao.deleteGoodsById(id);}

    public GoodsPo updateGoodsById(Integer id,GoodsPo goodsPo){return goodsDao.updateGoodsById(id,goodsPo);}

    public GoodsPo addGoods(GoodsPo goodsPo){return goodsDao.addGoods(goodsPo);}

    public List<GoodsPo> getGoodsByCategoryId(Integer id,Integer page,Integer limit){return goodsDao.getGoodsByCategoryId(id,page,limit);}

    public Boolean isOnSale(Integer id){return goodsDao.isOnSale(id);}

    public Goods getGoodsByIdForAdmin(Integer id){return goodsDao.findGoodByIdForAdmin(id);}
}
