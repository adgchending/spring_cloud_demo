package cn.itbluebox.order.controller;

import cn.itbluebox.order.entity.Product;
import cn.itbluebox.order.feign.ProductFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    //注入RestTemplate对象
    @Autowired
    private RestTemplate restTemplate;

    /*
  注入DiscoveryClient:
  SpringCloud 提供的获取原数组的工具类
      调用方法获取服务的元数据信息
   */
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private ProductFeignClient productFeignClient;

    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public Product findById(@RequestParam Long id) {
        //如何调用商品服务?
        return productFeignClient.findById(id);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestBody Product product) {
        return productFeignClient.save(product);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestBody Product product) {
        productFeignClient.update(product);
        return "更新成功";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam Long id) {
        productFeignClient.delete(id);
        return "删除成功";
    }
}
