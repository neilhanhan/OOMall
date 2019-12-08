package com.xmu.oomall.mapper;

import com.xmu.oomall.domain.Brand;

public interface BrandMapper {
    //创建一个品牌
    void createBrand();

    //根据条件搜索品牌
    void findAllBrand();

    /**
     * search brand info by id
     *
     * @param id id
     * @return Brand
     */
    根据品牌id查看详细信息
    void findBrandById(Integer id);

    /**
     * update brand by id
     *
     * @param id id
     * @return Brand
     */
    void updataBrandById(Integer id);

    /**
     * delete data by id
     *
     * @param id id
     * @return Brand
     */
    Brand deleteBrandById(Integer id);
}
