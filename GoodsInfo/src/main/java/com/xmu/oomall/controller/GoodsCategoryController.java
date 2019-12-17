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
     * GET
     * /categories
     * return List<goodsCategory>
     *      finished
     * POST
     * /categories
     * @RequestBody(goodsCategory)
     * return goodsCategory
     *      finished
     * GET
     * /categories/l1
     * return List<goodsCategory>
     *
     * GET
     * /categories/{id}
     * @PathVariable(id)
     * return goodsCategory
     *      finished
     *
     * PUT
     * /categories/{id}
     * @PathVariable(id) @RequestBody(goodsCategory)
     * return goodsCategory
     *      finished
     *
     * DELETE
     * /categories/{id}
     * @PathVariable(id)
     *
     * GET
     * /categories
     * return List<goodsCategory>
     *     finished
     *
     * GET
     * /categories/l1
     * return List<goodsCategory>
     *
     * GET
     * /categories/l1/{id}/l2
     * @PathVariable(id)
     * return goodsCategory
     *
     * GET
     * /categories/{id}
     * @PathVariable(id)
     * return goodsCategory
     */

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
    public GoodsCategory addGoodsCategory(@RequestBody GoodsCategory goodsCategory)
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
     * @return
     */
    @DeleteMapping("/categories/{id}")
    public void deleteGoodsCategory(@PathVariable Integer id)
    {
        goodsCategoryService.deleteGoodsCategory(id);
    }

    /**
     * 查看所有一级分类
     * @return
     */
    @GetMapping("/categories/l1")
    public List<GoodsCategory> listOneLevelGoodsCategory()
    {
        return goodsCategoryService.listOneLevelGoodsCategory();
    }

    /**
     * 获取当前一级分类下的二级分类
     *
     * @param id 分类类目ID
     * @return 当前分类栏目
     */
    @GetMapping("categories/l1/{id}/l2")
    public List<GoodsCategory> listSecondLevelGoodsCategoryById(@PathVariable Integer id)
    {
        return goodsCategoryService.listSecondLevelGoodsCategoryById(id);
    }
}
