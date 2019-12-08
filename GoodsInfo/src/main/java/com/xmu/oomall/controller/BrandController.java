package com.xmu.oomall.controller;

import com.xmu.oomall.domain.Brand;
import com.xmu.oomall.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BrandController {
    @Autowired
    private BrandService brandService;

    @GetMapping("/brands/{id}")
    public Brand getBrandById(@PathVariable("id")Integer id)
    {
        return brandService.getBrandById(id);
    }

    @PostMapping("/brands")
    public int createBrand(@RequestBody Brand brand)
    {
        return brandService.createBrand(brand);
    }
}
