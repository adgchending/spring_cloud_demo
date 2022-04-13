package cn.itbluebox.product.service.impl;

import cn.itbluebox.common.vo.ResultVo;
import cn.itbluebox.product.dao.BasicSchoolInforDao;
import cn.itbluebox.product.entity.BasicSchoolInfor;
import cn.itbluebox.product.service.BasicSchoolInforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasicSchoolInforServiceImpl implements BasicSchoolInforService {

    @Autowired
    private BasicSchoolInforDao basicSchoolInforDao;

    @Override
    public ResultVo findByID(Long id) {
        BasicSchoolInfor basicSchoolInfor = basicSchoolInforDao.selectById(id);
        if (basicSchoolInfor != null) {
            ResultVo resultVo = ResultVo.getInstance(Boolean.TRUE, ResultVo.ReturnCode.SUCCESS).settingObjectData(basicSchoolInfor);
            return resultVo;
        } else {
            return ResultVo.getInstance(Boolean.FALSE, "查询无数据");
        }
    }

    @Override
    public void insert(BasicSchoolInfor product) {
        basicSchoolInforDao.insert(product);
    }

    @Override
    public void update(BasicSchoolInfor product) {
        basicSchoolInforDao.updateById(product);
    }

    @Override
    public void delete(Long id) {
        basicSchoolInforDao.deleteById(id);
    }
}

