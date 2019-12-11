package com.xmu.oomall.service;

import com.xmu.oomall.dao.ProductDao;
import com.xmu.oomall.domain.Product;
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

    public List<Product> findProductsByGoodsId(Integer id) {
        return productDao.findProductsByGoodsId(id);
    }

    public Integer addProduct(Integer id,Product product) {
        return productDao.addProduct(id,product);
    }

    public Integer updateProduct(Integer id,Product product) {
        return productDao.updateProduct(id,product);
    }

    public Integer deleteProduct(Integer id ) {
        return productDao.deleteProduct(id);
    }

    public Product findProductsById(Integer id) {return productDao.findProductById(id);    }
}
