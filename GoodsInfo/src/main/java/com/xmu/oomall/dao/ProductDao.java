package com.xmu.oomall.dao;

import com.xmu.oomall.domain.Product;
import com.xmu.oomall.mapper.ProductMapper;
import com.xmu.oomall.service.ProductService;
import com.xmu.oomall.util.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.TimeUnit;
@Repository
public class ProductDao {
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private Config config;

    /**
     * 根据id返回产品
     *
     * @param id 产品id
     * @return
     */
    public Product findProductById(Integer id) {
        //从redis中获取product
        String key = "P_" + id;
        Product product = (Product) redisTemplate.opsForValue().get(key);
        if (product == null) {
            logger.debug("Redis中无product对象" + key);
            product = productMapper.findProductById(id);
            redisTemplate.opsForValue().set(key, product, config.getRedisExpireTime(), TimeUnit.MINUTES);
            logger.debug("Redis中存入 product = " + product);
        }
        return product;
//        return productMapper.findProductById(id);
    }

    /**
     * 查询商品下的产品列表
     *
     * @param id 商品id
     * @return 产品列表
     */
    public List<Product> findProductsByGoodsId(Integer id) {
        String key = "PofG_" + id;
        List<Product> products = (List<Product>) redisTemplate.opsForValue().get(key);
        if (products == null) {
            logger.debug("Redis中无products对象" + key);
            products = productMapper.findProductsByGoodsId(id);
            redisTemplate.opsForValue().set(key, products, config.getRedisExpireTime(), TimeUnit.MINUTES);
            logger.debug("Redis中存入 products = " + products);
        }
        return products;
    //    return productMapper.findProductsByGoodsId(id);
    }

    /**
     *
     * @param id 商品id
     * @param product 产品
     * @return
     */
    public Integer addProduct(Integer id,Product product) {
        product.setGoodsId(id);
        return productMapper.addProduct(product);
    }

    /**
     * 修改产品信息
     *
     * @param product 产品
     * @return
     */
    public Integer updateProduct(Integer id,Product product) {
        product.setId(id);
        return productMapper.updateProduct(product);
    }

    /**
     * 删除产品
     *
     * @param id 产品id
     * @return
     */
    public Integer deleteProduct(Integer id) {
        return productMapper.deleteProduct(id);
    }
}
