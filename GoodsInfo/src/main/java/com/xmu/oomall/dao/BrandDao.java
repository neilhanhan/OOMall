package com.xmu.oomall.dao;

import com.xmu.oomall.domain.Brand;
import com.xmu.oomall.mapper.BrandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BrandDao {
    @Autowired
    private BrandMapper brandMapper;

    public Brand getBrandById(Integer id)
    {
        return brandMapper.getBrandById(id);
    }

    public Integer addBrand(Brand brand)
    {
        return brandMapper.addBrand(brand);
    }

    public Brand updateBrandById(Integer id,Brand brand){return brandMapper.updateBrandById(id,brand);}

    public Brand deleteBrandById(Integer id)
    {
        Brand brand=brandMapper.getBrandById(id);
        brandMapper.deleteBrandById(id);
        return brand;
    }

    public List<Brand> listBrandByCodition(String name)
    {
        return brandMapper.listBrandByCodition(name);
    }
}
