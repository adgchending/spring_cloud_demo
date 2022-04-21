//package cn.itbluebox.alipay.servlet;
//
//import com.alipaypayment.model.AlipayPaymentConfig;
//import com.alipay.api.AlipayApiException;
//import com.alipay.api.internal.util.AlipaySignature;
//import com.df.util.SQLHelper;
//import org.apache.log4j.Logger;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.sql.ResultSet;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//
//@WebServlet("/alipaynotifyurl")
//public final class AlipayNotifyUrl extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	private static Logger logger = Logger.getLogger(AlipayNotifyUrl.class.getName());
//	protected void doGet(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html;charset=utf-8");
//
//		Map<String, String> params = new HashMap<String, String>();
//		Map<String, String[]> requestParams = request.getParameterMap();
//		for (Iterator<String> iter = requestParams.keySet().iterator(); iter
//				.hasNext();) {
//			String name = (String) iter.next();
//			String[] values = (String[]) requestParams.get(name);
//			String valueStr = "";
//			for (int i = 0; i < values.length; i++) {
//				valueStr = (i == values.length - 1) ? valueStr + values[i]
//						: valueStr + values[i] + ",";
//			}
//			// 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
//			// valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
//			params.put(name, valueStr);
//
//			//System.out.println(name + "---" + valueStr);
//		}
//
//		/*
//		 * total_amount---0.01 buyer_id---2088612176634600
//		 * trade_no---2016092621001004600242800539 notify_time---2016-09-26
//		 * 10:15:22 subject---aafasdf-拿铁（大杯） sign_type---RSA
//		 * notify_type---trade_status_sync out_trade_no---2016092610143253615
//		 * trade_status---TRADE_SUCCESS gmt_payment---2016-09-26 10:15:22
//		 * sign---
//		 * i+SOmUvk2KIJ4SlkMLfBoXOx0QQXGkEDdcwFdmb75DG7//+PREI7leP/PC9XUeehsefXYWI3L
//		 * w54Wda1sYcSzEuKIe7yRu8CmSrm8IgGnyVVBlXxIKA8SnfUO0oLnaCgklVvOSy13qK1dDzrc
//		 * /quUIe5h DihCEycybgNNwv75wg= gmt_create---2016-09-26 10:15:20
//		 * app_id---2016030101174800 seller_id---2088121812729340
//		 * notify_id---cd6fed1085b51848bb82886c86402dckmq
//		 */
//
//		boolean signVerified = false;
//		try {// 调用SDK验证签名
//			signVerified = AlipaySignature.rsaCheckV1(params,
//					AlipayPaymentConfig.ALIPAY_PUBLIC_KEY, AlipayPaymentConfig.CHARSET, AlipayPaymentConfig.SIGN_TYPE);
//		} catch (AlipayApiException e) {
//			e.printStackTrace();
//		}
//
//		if (signVerified) {
//			ResultSet rs = null;
//			try{
//				String trade_status = params.get("trade_status");
//				if (trade_status.equals("TRADE_SUCCESS")) {
//					String total_amount = params.get("total_amount");
//					String buyer_id = params.get("buyer_id");
//					String trade_no = params.get("trade_no");
//					String notify_time = params.get("notify_time");
//					String subject = params.get("subject");
//					String sign_type = params.get("sign_type");
//					String notify_type = params.get("notify_type");
//					String out_trade_no = params.get("out_trade_no");
//					String gmt_payment = params.get("gmt_payment");
//					String gmt_create = params.get("gmt_create");
//					String app_id = params.get("app_id");
//					String seller_id = params.get("seller_id");
//					String notify_id = params.get("notify_id");
//
//					String sql = "INSERT INTO [GZH_ReturnAlipay]([total_amount],[buyer_id],[trade_no],"
//							+ "[notify_time],[subject],[trade_status],[sign_type],[notify_type],"
//							+ "out_trade_no,gmt_payment,gmt_create,app_id,seller_id,notify_id,createtime) "
//							+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,getdate())";
//					// System.out.println(sql);
//					SQLHelper.ExecSql(sql, total_amount, buyer_id, trade_no,
//							notify_time, subject, trade_status, sign_type,
//							notify_type, out_trade_no, gmt_payment, gmt_create,
//							app_id, seller_id, notify_id);
//
//					sql = "{call GZH_PayCallBack(?,?,?,?)}";
//					rs = SQLHelper.getResultSet(sql, -1, out_trade_no,total_amount,3);
//
//					//验签成功后，校验成功后在response中返回success并继续商户自身业务处理
//					response.getWriter().write("success");
//					response.getWriter().flush();
//				}
//			}catch(Exception ex){
//				ex.printStackTrace();
//				response.getWriter().write("failure");
//				response.getWriter().flush();
//			} finally{
//				logger.info("alinotify 关闭连接");
//				SQLHelper.close(rs);
//			}
//		} else {
//			System.out.println("支付宝验签失败");
//			response.getWriter().write("failure");
//			response.getWriter().flush();
//		}
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}
//
//}
//
