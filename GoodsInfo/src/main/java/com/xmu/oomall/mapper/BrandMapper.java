package com.xmu.oomall.mapper;

import com.xmu.oomall.domain.Brand;
import com.xmu.oomall.domain.BrandPo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BrandMapper{

    List<BrandPo> getAllBrand();

    Integer addBrand(BrandPo brandPo);

    BrandPo getBrandById(Integer id);

    Integer updateBrand(BrandPo brandPo);

    Integer deleteBrand(Integer id);
}