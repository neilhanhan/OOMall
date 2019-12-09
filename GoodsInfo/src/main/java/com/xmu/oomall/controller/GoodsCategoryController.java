package com.xmu.oomall.controller;

import com.xmu.oomall.domain.GoodsCategory;
import com.xmu.oomall.service.GoodsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GoodsCategoryController {
    @Autowired
    private GoodsCategoryService goodsCategoryService;

    /**
     * 查看所有的分类
     * @return
     */
    @GetMapping("/categories")
    public List<GoodsCategory> listGoodsCategory()
    {
        return goodsCategoryService.listGoodsCategory();
    }

    /**
     * 新建一个分类
     * @param goodsCategory
     * @return
     */
    @PostMapping("/categories")
    public Integer addGoodsCategory(@RequestBody GoodsCategory goodsCategory)
    {
        return goodsCategoryService.addGoodsCategory(goodsCategory);
    }

    /**
     * 查看单个分类信息
     * @param id
     * @return
     */
    @GetMapping("/categories/{id}")
    public GoodsCategory getGoodsCategoryById(@PathVariable Integer id)
    {
        return goodsCategoryService.getGoodsCategoryById(id);
    }

    /**
     * 修改分类信息
     * @param id
     * @param goodsCategory
     * @return
     */
    @PutMapping("/categories/{id}")
    public GoodsCategory updateGoodsCategoryById(@PathVariable Integer id, @RequestBody GoodsCategory goodsCategory)
    {
        return  goodsCategoryService.updateGoodsCategoryById(id,goodsCategory);
    }

    /**
     * 删除单个分类
     * @param id
     * @param goodsCategory
     * @return
     */
    @DeleteMapping("/categories/{id}")
    public GoodsCategory deleteGoodsCategory(@PathVariable Integer id)
    {
        return goodsCategoryService.deleteGoodsCategory(id);
    }

}
