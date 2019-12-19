package com.xmu.oomall.dao;

import com.github.pagehelper.PageHelper;
import com.xmu.oomall.domain.Goods;
import com.xmu.oomall.domain.GoodsPo;
import com.xmu.oomall.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public class GoodsDao {

    @Autowired
    private GoodsMapper goodsMapper;

    public Goods findGoodsById(Integer id){
        Goods goods=goodsMapper.getGoodsById(id);
        if(goods.getStatusCode()!=0){
            return goods;
        }
        return goods;
    }

    public Goods findGoodByIdForAdmin(Integer id){
        return goodsMapper.getGoodsById(id);
    }

    public Integer deleteGoodsById(Integer id){
        GoodsPo goodsPo=goodsMapper.getGoodsPoById(id);
        goodsPo.setGmtModified(LocalDateTime.now());
        goodsMapper.updateGoodsById(goodsPo);
        return goodsMapper.deleteGoodsById(id);
    }

    public GoodsPo updateGoodsById(Integer id,GoodsPo goodsPo){
        goodsPo.setId(id);
        goodsPo.setGmtModified(LocalDateTime.now());
        goodsMapper.updateGoodsById(goodsPo);
        return goodsMapper.getGoodsPoById(id);
    }
    public GoodsPo addGoods(GoodsPo goodsPo){
            goodsPo.setGmtCreate(LocalDateTime.now());
            goodsPo.setGmtModified(LocalDateTime.now());
            goodsPo.setBeDeleted(false);
            goodsMapper.addGoods(goodsPo);
            return goodsPo;
    }

    public List<GoodsPo> getGoodsByCategoryId(Integer id,Integer page,Integer limit){
        PageHelper.startPage(page,limit);
        List<GoodsPo> goodsPoList=goodsMapper.getGoodsByCategoryId(id);
        return goodsPoList;
    }

    public Boolean isOnSale(Integer id){
        Goods goods=goodsMapper.getGoodsById(id);
        if(goods.getStatusCode()!=0){
            return true;}
        return false;
    }

    public List<GoodsPo> getGoodsByName(Integer page,Integer limit,String name){
        PageHelper.startPage(page,limit);
        List<GoodsPo> goodsPoList=goodsMapper.getGoodsByName(name);
        return goodsPoList;
    }

    public List<GoodsPo> getGoodsByNameForAdmin(Integer page,Integer limit,String name){
        PageHelper.startPage(page,limit);
        List<GoodsPo> goodsPoList=goodsMapper.getGoodsByName(name);
        return goodsPoList;
    }

    public List<GoodsPo> getGoods(){
        return goodsMapper.getGoods();
    }
}
