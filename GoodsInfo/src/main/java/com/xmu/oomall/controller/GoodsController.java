package com.xmu.oomall.controller;

import com.xmu.oomall.domain.Brand;
import com.xmu.oomall.domain.Goods;
import com.xmu.oomall.domain.GoodsCategory;
import com.xmu.oomall.service.BrandService;
import com.xmu.oomall.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private BrandService brandService;


    @GetMapping("/goods/{id}")
    public Goods findGoodsById(@PathVariable("id")Integer id){return goodsService.findGoodsById(id);}




}
