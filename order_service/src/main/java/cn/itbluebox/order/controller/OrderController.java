package cn.itbluebox.order.controller;

import cn.itbluebox.common.vo.ResultVo;
import cn.itbluebox.order.entity.BasicSchoolInfor;
import cn.itbluebox.order.feign.BasicSchoolInfortFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private BasicSchoolInfortFeignClient feignClient;

    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public ResultVo findById(@RequestParam Long id) {
        //如何调用商品服务?
        return feignClient.findById(id);
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
