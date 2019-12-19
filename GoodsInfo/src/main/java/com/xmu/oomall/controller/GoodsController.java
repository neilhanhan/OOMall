package com.xmu.oomall.controller;

import com.xmu.oomall.domain.*;
import com.xmu.oomall.service.BrandService;
import com.xmu.oomall.service.GoodsService;
import com.xmu.oomall.service.ProductService;
import com.xmu.oomall.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private ProductService productService;

    @GetMapping("/goods/{id}")
    public Object findGoodsById(@PathVariable("id")Integer id){
        Goods goods=goodsService.getGoodsById(id);
        if (goods==null) {
            return ResponseUtil.badArgumentValue();
        }
        return ResponseUtil.ok(goods);
    }

    @DeleteMapping("/goods/{id}")
    public Object deleteGoodsById(@PathVariable("id")Integer id){
        Integer isDeleted=goodsService.deleteGoodsById(id);
        if(isDeleted==0){
            return ResponseUtil.updatedDataFailed();
        }
        return ResponseUtil.ok();
    }

    @GetMapping("/categories/{id}/goods")
    public Object getGoodsByCategoryId(@PathVariable("id")Integer id,@RequestParam Integer page,@RequestParam Integer limit){

        List<GoodsPo> goodsPoList= goodsService.getGoodsByCategoryId(id,page,limit);
        if(goodsPoList.size()<page*limit||goodsPoList.size()==0){
            return ResponseUtil.badArgumentValue();
        }
        return ResponseUtil.ok(goodsPoList);
    }

    @PostMapping("/goods")
    public Object addGoods(@RequestBody GoodsPo goodsPo){
        goodsService.addGoods(goodsPo);
        if(goodsPo==null){
            return ResponseUtil.updatedDataFailed();
        }
        return ResponseUtil.ok(goodsPo);
    }

    @PutMapping("/goods/{id}")
    public Object updateGoods(@PathVariable("id")Integer id,@RequestBody GoodsPo goodsPo){

        goodsPo=goodsService.updateGoodsById(id,goodsPo);
        if(goodsPo==null){
            return ResponseUtil.updatedDataFailed();
        }
        return ResponseUtil.ok(goodsPo);
    }

    @GetMapping("/goods/{id}/products")
    public Object findProductsByGoodsId(@PathVariable("id")Integer id){
        List<ProductPo> productPoList=productService.findProductsByGoodsId(id);
        if(productPoList.size()==0){
            return ResponseUtil.badArgumentValue();
        }
        return  ResponseUtil.ok(productPoList);
    }

    @GetMapping("/products/{id}")
    public Object findProductsById(@PathVariable("id")Integer id){

       Product product=productService.findProductsById(id);
       if(product==null){
           return ResponseUtil.badArgumentValue();
       }
       return ResponseUtil.ok(product);
    }

    @PostMapping("/goods/{id}/products")
    public Object addProduct(@PathVariable("id")Integer id,@RequestBody ProductPo productPo){
        productService.addProduct(id,productPo);
        Product product=productService.findProductById(id);
        if(product==null){
            return ResponseUtil.badArgumentValue() ;
        }
        return ResponseUtil.ok(product);
    }

    @PutMapping("/products/{id}")
    public Object updateProduct(@PathVariable("id")Integer id,@RequestBody ProductPo productPo){
        productService.updateProduct(id,productPo);
        return ResponseUtil.ok(productPo);
    }

    @DeleteMapping("/products/{id}")
    public Object deleteProduct(@PathVariable("id")Integer id){
        Integer isDeleted= productService.deleteProduct(id);
        if(isDeleted==0){
            return ResponseUtil.updatedDataFailed();
        }
        return ResponseUtil.ok();
    }

    @GetMapping("/goods{id}/isOnSale")
    public Object isOnSale(@PathVariable("id")Integer id){return goodsService.isOnSale(id);}

    @GetMapping("/admin/goods/{id}")
    public Object getGoodsByIdForAdmin(@PathVariable("id")Integer id){return goodsService.getGoodsByIdForAdmin(id);}

    @GetMapping("/goods")
    public Object getGoodsByName(@RequestParam Integer page,@RequestParam Integer limit,@RequestParam String name){
        return goodsService.getGoodsByName(page,limit,name);
    }

    @GetMapping("/admin/goods")
    public Object getGoodsByNameForAdmin(@RequestParam Integer page,@RequestParam Integer limit,@RequestParam String name){
        return goodsService.getGoodsByName(page,limit,name);
    }



}
