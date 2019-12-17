package com.xmu.oomall.controller;

import com.xmu.oomall.domain.Brand;
import com.xmu.oomall.domain.BrandPo;
import com.xmu.oomall.service.BrandService;
import com.xmu.oomall.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class BrandController{
    @Autowired
    BrandService brandService;

    @GetMapping("/admins/brands")
    public Object getAllBrand(@RequestParam("page") Integer page,
                              @RequestParam("limit") Integer limit)
    {
        return brandService.getAllBrand(page,limit);
    }

    @PostMapping("/brands")
    public Object addBrand(@RequestBody BrandPo brandPo){
        return brandService.addBrand(brandPo);
    }

    @GetMapping("/brands/{id}")
    public Object getBrandById(@PathVariable("id") Integer id)
    {
        return brandService.getBrandById(id);
    }

    @PutMapping("/brands/{id}")
    public Object updateBrand(@PathVariable("id") Integer id,@RequestBody BrandPo brandPo)
    {
        return brandService.updateBrand(id,brandPo);
    }

    @DeleteMapping("/brands/{id}")
    public Object deleteBrand(@PathVariable("id") Integer id)
    {
        return brandService.deleteBrand(id);
    }

    @PostMapping("/pic")
    public Object uploadPic(@RequestBody MultipartFile pic)
    {
        return brandService.uploadPic(pic);
    }


}