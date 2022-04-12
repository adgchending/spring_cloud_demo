package cn.itbluebox.product.service;

import cn.itbluebox.product.entity.Product;

public interface ProductService {

    /*
    根据id查询
     */
    Product findByID(Long id);
    /*
    保存
     */
    void save(Product product);
    /*
    更新
     */
    void update(Product product);
    /*
    删除
     */
    void delete(Long id);

}
