package cn.itbluebox.product.controller;

import cn.itbluebox.product.entity.Product;
import cn.itbluebox.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public Product findById(@RequestParam Long id) {
        return productService.findByID(id);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestBody Product product) {
        productService.save(product);
        return "保存成功";
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(@RequestBody Product product) {
        productService.update(product);
        return "更新成功";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam Long id) {
        productService.delete(id);
        return "删除成功";
    }
}

