package com.xmu.oomall.service;

import com.xmu.oomall.dao.ProductDao;
import com.xmu.oomall.domain.Product;
import com.xmu.oomall.domain.ProductPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public Product findProductById(Integer id) {
        return productDao.findProductById(id);
    }

    public List<ProductPo> findProductsByGoodsId(Integer id) {
        return productDao.findProductsByGoodsId(id);
    }

    public List<ProductPo> addProduct(Integer id,ProductPo productPo) {
        return productDao.addProduct(id,productPo);
    }

    public ProductPo updateProduct(Integer id,ProductPo productPo) {
        return productDao.updateProduct(id,productPo);
    }

    public Integer deleteProduct(Integer id ) {
        return productDao.deleteProduct(id);
    }

    public Product findProductsById(Integer id) {return productDao.findProductById(id);    }
}
