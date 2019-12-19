package com.xmu.oomall.service;

import com.xmu.oomall.dao.BrandDao;
import com.xmu.oomall.domain.Brand;
import com.xmu.oomall.domain.BrandPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class BrandService{
    @Autowired
    BrandDao brandDao;

    public Object getAllBrand(Integer page,Integer limit)
    {
        return brandDao.getAllBrand(page,limit);
    }

    public Object addBrand(BrandPo brandPo) {
        return brandDao.addBrand(brandPo);
    }

    public Object getBrandById(Integer id) {
        return brandDao.getBrandById(id);
    }

    public Object updateBrand(Integer id, BrandPo brandPo) {
        return brandDao.updateBrand(id,brandPo);
    }

    public Object deleteBrand(Integer id) {
        return brandDao.deleteBrand(id);
    }

    public Object uploadPic(MultipartFile pic) {
        return brandDao.uploadPic(pic);
    }
}