package com.xmu.oomall.service;

import com.xmu.oomall.dao.BrandDao;
import com.xmu.oomall.domain.Brand;
import com.xmu.oomall.mapper.BrandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {
    @Autowired
    private BrandDao brandDao;

    public Brand getBrandById(Integer id)
    {
        return brandDao.getBrandById(id);
    }

//    public Brand updateBrandById(Integer id,Brand brand){return brandDao.updateBrandById(id,brand);}
//
//    public Integer addBrand(Brand brand)
//    {
//        return brandDao.addBrand(brand);
//    }

//    public Brand deleteBrandById(Integer id)
//    {
//        return brandDao.deleteBrandById(id);
//    }
//
//    public List<Brand>listBrandByCodition(String name)
//    {
//        return brandDao.listBrandByCodition(name);
//    }
}
