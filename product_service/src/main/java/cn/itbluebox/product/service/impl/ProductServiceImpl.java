package cn.itbluebox.product.service.impl;

import cn.itbluebox.product.dao.ProductDao;
import cn.itbluebox.product.entity.Product;
import cn.itbluebox.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Override
    public Product findByID(Long id) {
        return productDao.findById(id).get();
    }
    @Override
    public void save(Product product) {
        productDao.save(product);
    }
    @Override
    public void update(Product product) {
        productDao.save(product);
    }
    @Override
    public void delete(Long id) {
        productDao.deleteById(id);
    }
}

