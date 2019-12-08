package com.xmu.oomall.service;

import com.xmu.oomall.dao.BrandDao;
import com.xmu.oomall.domain.Brand;
import com.xmu.oomall.mapper.BrandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService {
    @Autowired
    private BrandDao brandDao;

    public Brand getBrandById(int id)
    {
        return brandDao.getBrandById(id);
    }

    public int createBrand(Brand brand)
    {
        return brandDao.createBrand(brand);
    }
}
