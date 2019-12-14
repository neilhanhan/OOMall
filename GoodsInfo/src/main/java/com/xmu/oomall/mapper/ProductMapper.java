    package com.xmu.oomall.mapper;

import com.xmu.oomall.domain.Product;
import com.xmu.oomall.domain.ProductPo;
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
    List<ProductPo> findProductsByGoodsId(Integer id);

    /**
     * 添加产品
     * @param productPo 产品
     * @return 产品
     */
    List<ProductPo> addProduct(ProductPo productPo);

    /**
     * 修改产品信息
     * @param productPo 产品
     * @return 产品
     */
    ProductPo updateProduct(ProductPo productPo);

    /**
     * 删除产品
     * @param id 产品id
     * @return
     */
    Integer deleteProduct(Integer id);
}
