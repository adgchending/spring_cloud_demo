//package cn.itbluebox.alipay.servlet;
//
//import com.alipaypayment.model.AlipayPaymentConfig;
//import com.alipaypayment.server.AlipayPaymentServer;
//import com.alipay.api.AlipayApiException;
//import com.alipay.api.AlipayClient;
//import com.alipay.api.request.AlipayTradeWapPayRequest;
//import com.df.service.SaleOrderService;
//import com.df.util.SQLHelper;
//import com.wxpay.util.TenpayUtil;
//import org.apache.log4j.Logger;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.net.URLDecoder;
//import java.sql.ResultSet;
//
///**
// * 支付宝支付
// */
//@WebServlet("/alipayPaymentServlet")
//public class AlipayPaymentServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	private static Logger logger = Logger.getLogger(AlipayPaymentServlet.class.getName());
//	public void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		doPost(request, response);
//	}
//
//	public void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html;charset=utf-8");
//
//		String MatName = request.getParameter("MatName");// 菜名，
//		MatName = URLDecoder.decode(MatName, "utf-8");
//		String money = request.getParameter("money");// 金额，
//		String keyvalue = request.getParameter("keyvalue");
//		// String openId = request.getParameter("Icum").trim();
//
//		//openId 需要传  ，需要修改GZH_ItemUpdateAction存储过程------------------------
//
//		//判断订单超时
//		SaleOrderService orderService = new SaleOrderService();
//		if(orderService.isSaleOrderOK(keyvalue.split("_")[0])){
//			response.setContentType("text/html;charset=UTF-8");
//			response.getWriter().write("支付超时");// 直接将完整的表单html输出到页面
//			response.getWriter().flush();
//			return;
//		}
//
//		String currTime = TenpayUtil.getCurrTime();
//		String strorderTime = currTime.substring(0, 12);
//		// 用户支付产生的唯一订单号
//		String out_trade_no = strorderTime + TenpayUtil.buildRandom(7);
//
//		AlipayClient alipayClient = AlipayPaymentServer.getAlipayClient(); // 获得初始化的AlipayClient
//
//		AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();// 创建API对应的request
//		alipayRequest
//				.setReturnUrl("http://wx.wing-cafe.com/pay/alipayreturnurl");
//		alipayRequest
//				.setNotifyUrl("http://wx.wing-cafe.com/pay/alipaynotifyurl");// 在公共参数中设置回跳和通知地址
//		alipayRequest.setBizContent("{" + "    \"out_trade_no\":\""
//				+ out_trade_no + "\"," + "    \"total_amount\":" + money + ","
//				+ "    \"subject\":\"" + MatName + "\","
//				+ "    \"seller_id\":\"" + AlipayPaymentConfig.SELLER_ID + "\","
//				+ "    \"product_code\":\"QUICK_WAP_PAY\"" + "  }");// 填充业务参数
//		// 调用SDK生成表单
//		String form = "";
//		try {
//			form = alipayClient.pageExecute(alipayRequest).getBody();
//		} catch (AlipayApiException e) {
//			e.printStackTrace();
//		}
//		ResultSet rs = null;
//		ResultSet rs1 = null;
//		try {
//			//System.out.println(keyvalue);
//			//System.out.println(keyvalue.split("_")[0]);
//			String sql = "{call GZH_PayCreateCallBack(?,?,?,?)}";
//			rs = SQLHelper.getResultSet(sql, keyvalue.split("_")[0], out_trade_no,money,3);
//
//			sql = "{call GZH_ItemUpdateAction(?,?,?,?,?)}";
//			rs1 = SQLHelper.getResultSet(sql, keyvalue, out_trade_no, null,
//					AlipayPaymentConfig.APP_ID, "paycoupons");
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally{
//			logger.info("alipay 关闭连接");
//			SQLHelper.close(rs);
//			SQLHelper.close(rs1);
//		}
//
//		response.setContentType("text/html;charset=UTF-8");
//		response.getWriter().write(form);// 直接将完整的表单html输出到页面
//		response.getWriter().flush();
//	}
//}
