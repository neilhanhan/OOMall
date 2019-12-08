package com.xmu.oomall.mapper;

import com.xmu.oomall.domain.Brand;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BrandMapper {
    /**
     * create a brand
     *
     * @param brand
     * @return id
     */
    Integer addBrand(Brand brand);

    /**
     * search brands by param
     *
     * @param ???
     * @return List<Brand>
     */
    List<Brand> listBrandByCodition(String name);

    /**
     * search brand info by id
     *
     * @param id id
     * @return Brand
     */
    Brand getBrandById(Integer id);

    /**
     * update brand by id
     *
     * @param id ,brand
     * @return Brand
     */
    Brand updateBrandById(Integer id,Brand brand);

    /**
     * delete data by id
     *
     * @param id id
     * @return
     */
    void deleteBrandById(Integer id);
}
