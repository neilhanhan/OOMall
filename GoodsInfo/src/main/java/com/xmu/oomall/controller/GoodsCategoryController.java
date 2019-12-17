package com.xmu.oomall.controller;

import com.xmu.oomall.domain.GoodsCategoryPo;
import com.xmu.oomall.service.GoodsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GoodsCategoryController{
    @Autowired
    GoodsCategoryService goodsCategoryService;

    @GetMapping("/categories")
    public Object getAllCategories(@RequestParam("page") Integer page,
                                   @RequestParam("limit") Integer limit)
    {
        return goodsCategoryService.getAllCategories(page,limit);
    }

    @PostMapping("/categories")
    public Object addCategory(@RequestBody GoodsCategoryPo goodsCategoryPo)
    {
        return goodsCategoryService.addCategory(goodsCategoryPo);
    }

    @GetMapping("/categories/{id}")
    public Object getCategoryById(@PathVariable("id") Integer id)
    {
        return goodsCategoryService.getCategoryById(id);
    }

    @PutMapping("/categories/{id}")
    public Object updateCategory(@PathVariable("id") Integer id,@RequestBody GoodsCategoryPo goodsCategoryPo)
    {
        return goodsCategoryService.updateCategory(id,goodsCategoryPo);
    }

    @DeleteMapping("/categories/{id}")
    public Object deleteCategory(@PathVariable("id") Integer id)
    {
        return goodsCategoryService.deleteCategory(id);
    }

    @GetMapping("/categories/l1")
    public Object getLevelOneCategories()
    {
        return goodsCategoryService.getLevelOneCategories();
    }

    @GetMapping("/categories/l1/{id}/l2")
    public Object getLevelTwoCategories(@PathVariable("id") Integer id)
    {
        return goodsCategoryService.getLevelTwoCategories(id);
    }
}