package com.xmu.oomall.mapper;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.xmu.oomall.domain.Goods;
import com.xmu.oomall.domain.GoodsPo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GoodsMapper {
    /**
     * 根据商品id查询商品
     * @param id
     * @return
     */
    Goods getGoodsById(Integer id);

    /**
     * 根据id获取商品Po
     * @param id
     * @return
     */
    GoodsPo getGoodsPoById(Integer id);

    /**
     * 根据商品id删除商品
     * @param id
     * @return
     */
    Integer deleteGoodsById(Integer id);

    /**
     * 更新商品信息
     * @param goodsPo
     * @return
     */
    Integer updateGoodsById(GoodsPo goodsPo);

    /**
     * 新增商品
     * @param goodsPo
     * @return
     */
    Integer addGoods(GoodsPo goodsPo);

    /**
     * 获取某一类别下的商品
     * @param id
     * @return
     */
    List<GoodsPo> getGoodsByCategoryId(Integer id);

    /**
     * 根据商品名称查询商品
     * @param name
     * @return
     */
    List<GoodsPo> getGoodsByName(String name);

    /**
     * 管理员根据商品名称查询商品
     * @param name
     * @return
     */
    List<GoodsPo> getGoodsByNameForAdmin(String name);


}
