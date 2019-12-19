package com.xmu.oomall.service;

import com.xmu.oomall.dao.GoodsCategoryDao;
import com.xmu.oomall.domain.GoodsCategoryPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsCategoryService{
    @Autowired
    GoodsCategoryDao goodsCategoryDao;

    public Object getAllCategories(Integer page,Integer limit){return goodsCategoryDao.getAllCategories(page, limit);}

    public Object addCategory(GoodsCategoryPo goodsCategoryPo){return goodsCategoryDao.addCategory(goodsCategoryPo);}

    public Object getCategoryById(Integer id){return goodsCategoryDao.getCategoryById(id);}

    public Object updateCategory(Integer id,GoodsCategoryPo goodsCategoryPo){return goodsCategoryDao.updateCategory(id,goodsCategoryPo);}

    public Object deleteCategory(Integer id){return goodsCategoryDao.deleteCategory(id);}

    public Object getLevelOneCategories(){return goodsCategoryDao.getLevelOneCategories();}

    public Object getLevelTwoCategories(Integer id){return goodsCategoryDao.getLevelTwoCategories(id);}
}