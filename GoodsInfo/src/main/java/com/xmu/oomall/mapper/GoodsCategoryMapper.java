package com.xmu.oomall.mapper;

import com.xmu.oomall.domain.Goods;
import com.xmu.oomall.domain.GoodsCategoryPo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GoodsCategoryMapper{

    List<GoodsCategoryPo> getAllCategories();

    Integer addCategory(GoodsCategoryPo goodsCategoryPo);

    GoodsCategoryPo getCategoryById(Integer id);

    Integer updateCategory(GoodsCategoryPo goodsCategoryPo);

    Integer deleteCategory(Integer id);

    List<GoodsCategoryPo> getLevelOneCategories();

    List<GoodsCategoryPo> getLevelTwoCategories(Integer id);

}