package cn.itbluebox.order.feign;

import cn.itbluebox.order.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * ProductFeignClient上声明需要调用的微服务名称
 * @FeignClient
 *      name: 服务提供者的名称
 */
@FeignClient(name = "service-product")
public interface ProductFeignClient {
    /*
    配置需要调用的微服务接口
    这里消费者的url需要和服务者的保持一致
     */
    @RequestMapping(value = "/product/select", method = RequestMethod.GET)
    Product findById(@RequestParam Long id);

    @RequestMapping(value = "/product/save", method = RequestMethod.POST)
    String save(Product product);

    @RequestMapping(value = "/product/update", method = RequestMethod.POST)
    void update(Product product);

    @RequestMapping(value = "/product/delete", method = RequestMethod.GET)
    void delete(@RequestParam Long id);
}
