package cn.itbluebox.order.controller;

import cn.itbluebox.common.vo.ResultVo;
import cn.itbluebox.order.command.OrderCommand;
import cn.itbluebox.order.entity.BasicSchoolInfor;
import cn.itbluebox.order.feign.BasicSchoolInfortFeignClient;
import cn.itbluebox.order.entity.TbProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private BasicSchoolInfortFeignClient feignClient;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/buy/{id}", method = RequestMethod.GET)
    public TbProduct findById(@PathVariable Long id) {
        //如何调用商品服务?
        //页面输入http://localhost:9002/order/buy/1
        //会调用product_service项目里的findById方法,如果调用失败则会调用熔断降级方法
        TbProduct tbProduct = feignClient.findById(id);
//        TbProduct tbProduct = new OrderCommand(restTemplate, id).execute();
        return tbProduct;
    }

    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public ResultVo select(@RequestParam Long id) {
        //如何调用商品服务?
        return feignClient.select(id);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String save(@RequestBody BasicSchoolInfor product) {
        return feignClient.save(product);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestBody BasicSchoolInfor product) {
        feignClient.update(product);
        return "更新成功";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam Long id) {
        feignClient.delete(id);
        return "删除成功";
    }
}
