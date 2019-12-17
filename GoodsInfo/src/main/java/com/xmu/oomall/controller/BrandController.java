package com.xmu.oomall.controller;

import com.xmu.oomall.domain.Brand;
import com.xmu.oomall.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.time.LocalDateTime;

@RestController
public class BrandController{
    @Autowired
    private BrandService brandService;

    /**
     *GET
     * /admins/brands
     * RequestParam(page)
     * RequestParam(limit)
     * return List<brand>
     *     finished;
     *
     * POST
     * /brands
     * @RequestBody(brand)
     * return brand
     *      finished;
     *
     * GET
     * /brands/{id}
     * @PathVariable(id)
     * return brand
     *      finished;
     *
     * PUT
     * /brands/{id}
     * @PathVariable(id) @RequestBody(brand)
     * return brand
     *      finished;
     *
     * DELETE
     * /brands/{id}
     * @PathVariable(id)
     *      finished;
     *
     * GET
     * /brands
     * return List<brand>
     *     finished
     *
     * GET
     * /brands/{id}
     * @PathVariable(id)
     * return brand
     *      finished
     */

    @GetMapping("/brands/{id}")
    public Brand getBrandById(@PathVariable("id")Integer id)
    {
        return brandService.getBrandById(id);
    }

    @PutMapping("/brands/{id}")
    public Brand updateBrandById(@PathVariable Integer id,@RequestBody Brand brand)
    {
        return brandService.updateBrandById(id,brand);
    }

    @PostMapping("/brands")
    public Brand addBrand(@RequestBody Brand brand)
    {
        return brandService.addBrand(brand);
    }

    @DeleteMapping("/brands/{id}")
    public Brand deleteBrandById(@PathVariable Integer id)
    {
        return brandService.deleteBrandById(id);
    }

    @GetMapping("/admins/brands")
    public List<Brand> listBrandByCodition(@RequestParam Integer page,
                                           @RequestParam Integer limit
                                           )
    {
        if(page==null)
        {
            page=1;
        }
        if(limit==null)
        {
            limit=10;
        }
        return brandService.listBrandByCodition(page,limit);
    }

    @GetMapping("/brands")
    public List<Brand> listBrand()
    {
        return brandService.listBrand();
    }
}
