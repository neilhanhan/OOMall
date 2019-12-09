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

//    public Brand updateBrandById(Integer id,Brand brand)
//    {
//        brand.setId(id);
//        return brandMapper.updateBrandById(brand);
//    }
//
//    public Integer addBrand(Brand brand)
//    {
//        brandMapper.addBrand(brand);
//        int id=brand.getId();
//        return id;
//    }


//    public Brand deleteBrandById(Integer id)
//    {
//        Brand brand=brandMapper.getBrandById(id);
//        brandMapper.deleteBrandById(id);
//        return brand;
//    }
//
//    public List<Brand> listBrandByCodition(String name)
//    {
//        return brandMapper.listBrandByCodition(name);
//    }
}
