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
     * @param Brand brand;
     * @return id id
     */
    Integer createBrand(Brand brand);

    /**
     * search brands by param
     *
     * @param ???
     * @return List<Brand>
     */
    List<Brand> findAllBrand();

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
     * @param id id
     * @return Brand
     */
    Brand updataBrandById(Integer id);

    /**
     * delete data by id
     *
     * @param id id
     * @return Brand
     */
    Brand deleteBrandById(Integer id);
}
