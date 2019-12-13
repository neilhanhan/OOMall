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

    public Brand updateBrandById(Integer id,Brand brand)
    {
        brand.setId(id);
        brandMapper.updateBrandById(brand);
        return brandMapper.getBrandById(id);
    }

    public Brand addBrand(Brand brand)
    {
        brandMapper.addBrand(brand);
        return brand;
    }


    public Brand deleteBrandById(Integer id)
    {
        Brand brand=brandMapper.getBrandById(id);
        brandMapper.deleteBrandById(id);
        return brand;
    }

    public List<Brand> listBrandByCodition(Integer page,Integer limit)
    {
        List<Brand> brandList=brandMapper.listBrandByCodition();
        int pagecount=brandList.size()/limit;
        int remain=brandList.size()%limit;
        if(remain>0){
            pagecount++;
        }
        if(page>pagecount) {
            return null;
        }
        List<Brand> subBrandList=null;
        if(remain==0) {
            subBrandList=brandList.subList((page-1)*limit,page*limit);
        }
        else{
            if (page==pagecount){
                subBrandList=brandList.subList((page-1)*limit,brandList.size());
            }else{
                subBrandList=brandList.subList((page-1)*limit,page*limit);
            }
        }

        return subBrandList;
    }

    public List<Brand> listBrand()
    {
        return brandMapper.listBrand();
    }
}
