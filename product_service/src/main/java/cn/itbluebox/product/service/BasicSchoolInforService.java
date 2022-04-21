package cn.itbluebox.product.service;

import cn.itbluebox.common.vo.ResultVo;
import cn.itbluebox.product.pojo.BasicSchoolInfor;
import cn.itbluebox.product.pojo.TbProduct;

public interface BasicSchoolInforService {

    /*
    根据id查询
     */
    ResultVo selectById(Long id);
    /*
    保存
     */
    void insert(BasicSchoolInfor product);
    /*
    更新
     */
    void update(BasicSchoolInfor product);
    /*
    删除
     */
    void delete(Long id);

    TbProduct findById(Long id);
}

