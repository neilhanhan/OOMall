package com.xmu.oomall.dao;

import com.xmu.oomall.domain.Brand;
import com.xmu.oomall.mapper.BrandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BrandDao {
    @Autowired
    private BrandMapper brandMapper;

    public Brand getBrandById(int id)
    {
        return brandMapper.getBrandById(id);
    }

    public int createBrand(Brand brand)
    {
        return brandMapper.createBrand(brand);
    }

}
