package cn.itbluebox.product.controller;

import cn.itbluebox.common.vo.ResultVo;
import cn.itbluebox.product.entity.BasicSchoolInfor;
import cn.itbluebox.product.service.BasicSchoolInforService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@Api(tags = "学校信息")
public class BasicSchoolInforController {
    @Autowired
    private BasicSchoolInforService productService;

    @ApiOperation(value = "根据学校id获取学校")
    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public ResultVo<BasicSchoolInfor> findById(@ApiParam(value = "学校id", required = true) @RequestParam Long id) {
        ResultVo resultVo = productService.findByID(id);
        return resultVo;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestBody BasicSchoolInfor product) {
        productService.insert(product);
        return "保存成功";
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
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

