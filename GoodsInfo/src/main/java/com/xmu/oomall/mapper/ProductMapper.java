    package com.xmu.oomall.mapper;

import com.xmu.oomall.domain.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductMapper {
    /**
     * 根据id返回产品
     * @param id 产品id
     * @return
     */
    Product findProductById(Integer id);

    /**
     * 查询商品下的产品列表
     * @param id 商品id
     * @return 产品列表
     */
    List<Product> findProductsByGoodsId(Integer id);

    /**
     * 添加产品
     * @param product 产品
     * @return 产品
     */
    Integer addProduct(Product product);

    /**
     * 修改产品信息
     * @param product 产品
     * @return 产品
     */
    Integer updateProduct(Product product);

    /**
     * 删除产品
     * @param id 产品id
     * @return
     */
    Integer deleteProduct(Integer id);
}
