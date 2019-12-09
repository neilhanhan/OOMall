package com.xmu.oomall.service;

import com.xmu.oomall.dao.GoodsCategoryDao;
import com.xmu.oomall.domain.GoodsCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsCategoryService {
    @Autowired
    private GoodsCategoryDao goodsCategoryDao;

    public List<GoodsCategory> listGoodsCategory()
    {
        return goodsCategoryDao.listGoodsCategory();
    }

    public Integer addGoodsCategory(GoodsCategory goodsCategory)
    {
        return goodsCategoryDao.addGoodsCategory(goodsCategory);
    }

    public GoodsCategory getGoodsCategoryById(Integer id)
    {
        return goodsCategoryDao.getGoodsCategoryById(id);
    }

    public GoodsCategory updateGoodsCategoryById(Integer id,GoodsCategory goodsCategory)
    {
        return goodsCategoryDao.updateGoodsCategoryById(id,goodsCategory);
    }

    public GoodsCategory deleteGoodsCategory(Integer id)
    {
        return goodsCategoryDao.deleteGoodsCategory(id);
    }
}
