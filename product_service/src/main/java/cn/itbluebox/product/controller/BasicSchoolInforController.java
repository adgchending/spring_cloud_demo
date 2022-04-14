package cn.itbluebox.product.controller;

import cn.itbluebox.common.vo.ResultVo;
import cn.itbluebox.product.entity.BasicSchoolInfor;
import cn.itbluebox.product.entity.TbProduct;
import cn.itbluebox.product.service.BasicSchoolInforService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@Api(tags = "学校信息")
public class BasicSchoolInforController {
    @Autowired
    private BasicSchoolInforService productService;

    @Value("${server.port}")
    private String port;

    @Value("${spring.cloud.client.ip-address}")
    private String ip;


    @ApiOperation(value = "查询手机")
    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public TbProduct findById(@RequestParam Long id) {
//        try {
//            Thread.sleep(2000l);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        TbProduct product = productService.findById(id);
        product.setCaption("访问的服务地址222:"+ip + ":" + port);
        return product;
    }

    @ApiOperation(value = "根据学校id获取学校")
    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public ResultVo<BasicSchoolInfor> selectById(@ApiParam(value = "学校id", required = true) @RequestParam Long id) {
        ResultVo resultVo = productService.selectById(id);
        return resultVo;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestBody BasicSchoolInfor product) {
        productService.insert(product);
        return "保存成功";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestBody BasicSchoolInfor product) {
        productService.update(product);
        return "更新成功";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam Long id) {
        productService.delete(id);
        return "删除成功";
    }
}

