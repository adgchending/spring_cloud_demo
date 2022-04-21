package cn.itbluebox.order.feign;

import cn.itbluebox.common.vo.ResultVo;
import cn.itbluebox.order.entity.BasicSchoolInfor;
import cn.itbluebox.order.entity.TbProduct;
import org.springframework.stereotype.Component;

@Component
public class ProductFeignClientCallBack implements BasicSchoolInfortFeignClient {

	/**
	 * 熔断降级的方法
	 */
	public TbProduct findById(Long id) {
		TbProduct product = new TbProduct();
		product.setProductName("feign调用接口失败,触发熔断降级方法");
		return product;
	}

	@Override
	public ResultVo select(Long id) {
//		ResultVo resultVo = new ResultVo();
//		resultVo.setMsg("降级");
		return null;
	}

	@Override
	public String save(BasicSchoolInfor product) {
		return "降级";
	}

	@Override
	public void update(BasicSchoolInfor product) {

	}

	@Override
	public void delete(Long id) {

	}
}
