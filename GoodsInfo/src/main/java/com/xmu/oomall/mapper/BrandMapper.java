package com.xmu.oomall.mapper;

import com.xmu.oomall.domain.Brand;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BrandMapper {

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
     * @param brand
     * @return Brand
     */
    Integer updateBrandById(Brand brand);

    /**
     * create a brand
     *
     * @param brand
     * @return id
     */
    void addBrand(Brand brand);

    /**
     * delete data by id
     *
     * @param id id
     * @return
     */
    Integer deleteBrandById(Integer id);

    /**
     * search brands by param
     *
     * @param ???
     * @return List<Brand>
     */
    List<Brand> listBrandByCodition();

    List<Brand> listBrand();
}
