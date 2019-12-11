package com.xmu.oomall.controller;

import com.xmu.oomall.domain.Brand;
import com.xmu.oomall.domain.Goods;
import com.xmu.oomall.domain.GoodsCategory;
import com.xmu.oomall.service.BrandService;
import com.xmu.oomall.domain.Product;
import com.xmu.oomall.service.GoodsService;
import com.xmu.oomall.service.ProductService;
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
    public Goods findGoodsById(@PathVariable("id")Integer id){return goodsService.findGoodsById(id);}

    @GetMapping("/goods/{id}/products")
    public List<Product> findProductsByGoodsId(@PathVariable("id")Integer id){
        return productService.findProductsByGoodsId(id);
    }

    @GetMapping("/products/{id}")
    public Product findProductsById(@PathVariable("id")Integer id){
        return productService.findProductsById(id);
    }

    @PostMapping("/goods/{id}/products")
    public Integer addProduct(@PathVariable("id")Integer id,@RequestBody Product product){
        return productService.addProduct(id,product);
    }

    @PutMapping("/goods/{goodsid}/products/{id}")
    public Integer updateProduct(@PathVariable("id")Integer id,@RequestBody Product product){
        return productService.updateProduct(id,product);
    }

    @DeleteMapping("/goods/{goodsid}/products/{id}")
    public Integer deleteProduct(@PathVariable("id")Integer id){
        return productService.deleteProduct(id);
    }
}
