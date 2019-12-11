package com.xmu.oomall.dao;

import com.xmu.oomall.domain.GoodsCategory;
import com.xmu.oomall.mapper.GoodsCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GoodsCategoryDao {
    @Autowired
    private GoodsCategoryMapper goodsCategoryMapper;

    public List<GoodsCategory> listGoodsCategory()
    {
        return goodsCategoryMapper.listGoodsCategory();
    }

    public GoodsCategory addGoodsCategory(GoodsCategory goodsCategory)
    {
        goodsCategoryMapper.addGoodsCategory(goodsCategory);
        return goodsCategory;
    }

    public GoodsCategory getGoodsCategoryById(Integer id)
    {
        return goodsCategoryMapper.getGoodsCategoryById(id);
    }

    public GoodsCategory updateGoodsCategoryById(Integer id,GoodsCategory goodsCategory)
    {
        goodsCategory.setId(id);
        goodsCategoryMapper.updateGoodsCategoryById(goodsCategory);
        return goodsCategoryMapper.getGoodsCategoryById(id);
    }

    public GoodsCategory deleteGoodsCategory(Integer id)
    {
        GoodsCategory goodsCategory=goodsCategoryMapper.getGoodsCategoryById(id);
        goodsCategoryMapper.deleteGoodsCategory(id);
        return goodsCategory;
    }

    public List<GoodsCategory> listOneLevelGoodsCategory()
    {
        return goodsCategoryMapper.listOneLevelGoodsCategory();
    }

    public List<GoodsCategory> listSecondLevelGoodsCategoryById(Integer id)
    {
        return goodsCategoryMapper.listSecondLevelGoodsCategoryById(id);
    }
}
