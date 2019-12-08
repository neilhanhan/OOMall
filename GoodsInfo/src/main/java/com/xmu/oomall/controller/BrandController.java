package com.xmu.oomall.controller;

import com.xmu.oomall.domain.Brand;
import com.xmu.oomall.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public int addBrand(@RequestBody Brand brand)
    {
        return brandService.addBrand(brand);
    }

    @PutMapping("/brands/{id}")
    public Brand updateBrandById(@PathVariable Integer id,@RequestBody Brand brand)
    {
        return brandService.updateBrandById(id,brand);
    }

    @DeleteMapping("/brands/{id}")
    public Brand deleteBrandById(@PathVariable Integer id)
    {
        return brandService.deleteBrandById(id);
    }

    @GetMapping("/admins/brands")
    public List<Brand> listBrandByCodition(String name,
                                           @RequestParam(defaultValue = "1") Integer page,
                                           @RequestParam(defaultValue = "10")Integer limit)
    {
        return brandService.listBrandByCodition(name);
    }
}
