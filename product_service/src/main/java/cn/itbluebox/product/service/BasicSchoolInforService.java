package cn.itbluebox.product.service;

import cn.itbluebox.common.vo.ResultVo;
import cn.itbluebox.product.entity.BasicSchoolInfor;

public interface BasicSchoolInforService {

    /*
    根据id查询
     */
    ResultVo findByID(Long id);
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

}

