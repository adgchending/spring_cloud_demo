//package cn.itbluebox.alipay.servlet;
//
//import com.alipaypayment.server.AlipayPaymentServer;
//import com.alipay.api.AlipayApiException;
//import com.alipay.api.AlipayClient;
//import com.alipay.api.request.AlipayTradeRefundRequest;
//import com.alipay.api.response.AlipayTradeRefundResponse;
//import com.df.util.SQLHelper;
//import com.wxpay.util.TenpayUtil;
//import net.sf.json.JSONObject;
//import org.apache.log4j.Logger;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.sql.ResultSet;
//
///**
// * 支付宝退款
// */
//@WebServlet("/alipayPaymentRefund")
//public final class AlipayPaymentRefund extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	private static Logger logger = Logger.getLogger(AlipayPaymentRefund.class.getName());
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html;charset=utf-8");
//
//		String out_trade_no = request.getParameter("outtradeno"); // 商家订单号
//		String total_fee = request.getParameter("total_fee"); // 订单金额
//		String userid = request.getParameter("userid"); // 退款操作人
//
//
//		String currTime = TenpayUtil.getCurrTime();
//		String strorderTime = currTime.substring(0, 12);
//		// 用户支付产生的唯一订单号
//		String refundorderNo = "refund" + strorderTime
//				+ TenpayUtil.buildRandom(7);
//
//		AlipayClient alipayClient = AlipayPaymentServer.getAlipayClient(); // 获得初始化的AlipayClient
//		AlipayTradeRefundRequest refundrequest = new AlipayTradeRefundRequest();//创建API对应的request类
//		refundrequest.setBizContent("{\"out_trade_no\":"+out_trade_no+","
//				+ "\"trade_no\":\"\","
//				+ "\"out_request_no\":\""+refundorderNo+"\","
//				+ "\"refund_amount\":"+total_fee+"}");//设置业务参数
//
//		JSONObject jsonobj = new JSONObject();
//		ResultSet rs =  null;
//		try {//通过alipayClient调用API，获得对应的response类
//			AlipayTradeRefundResponse refundresponse = alipayClient.execute(refundrequest);
//			String json = refundresponse.getBody();
//			//System.out.println("json---" + json);
//			JSONObject jsonObject = JSONObject.fromObject(json);
//			String responsejson = jsonObject.get("alipay_trade_refund_response").toString();
//			JSONObject responseObject = JSONObject.fromObject(responsejson);
//			String code = responseObject.get("code").toString();
//			int ok=0;
//			if(refundresponse.isSuccess()){
//				String msg = responseObject.get("msg").toString();
//				String trade_no = responseObject.get("trade_no").toString();
//				//String out_trade_no = responseObject.get("out_trade_no").toString();
//				String buyer_logon_id = responseObject.get("buyer_logon_id").toString();
//				String fund_change = responseObject.get("fund_change").toString();
//				String refund_fee = responseObject.get("refund_fee").toString();
//				String gmt_refund_pay = responseObject.get("gmt_refund_pay").toString();
//
//				String buyer_user_id = responseObject.get("buyer_user_id").toString();
//
//				String strSql = "INSERT INTO [GZH_RefundAliPay]([code],[msg],[trade_no],"
//						+ "[out_trade_no],[buyer_logon_id],[fund_change],[refund_fee],"
//						+ "[gmt_refund_pay],[buyer_user_id],[json],[createtime])"
//						+ "values(?,?,?,?,?,?,?,?,?,?,GETDATE())";
//				SQLHelper.ExecSql(strSql, code, msg, trade_no,
//						out_trade_no,buyer_logon_id,fund_change,refund_fee,
//						gmt_refund_pay,buyer_user_id,json);
//				ok=1;
//
//				jsonobj.put("message", "退款成功");
//			} else {
//				String sub_msg = responseObject.get("sub_msg").toString();
//				String strSql = "INSERT INTO [GZH_RefundAliPay]([code],[msg],[out_trade_no],"
//						+ "[refund_fee],[json],[createtime])"
//						+ "values(?,?,?,?,?,GETDATE())";
//				SQLHelper.ExecSql(strSql, code, sub_msg, out_trade_no,
//						total_fee,json);
//				//System.out.println("调用失败");
//				jsonobj.put("message", "退款失败");
//				ok=2;
//			}
//			jsonobj.put("success", ok);
//			String sql = "{call GZH_PayRefundCallBack(?,?,?,?)}";
//			rs = SQLHelper.getResultSet(sql, out_trade_no,3,ok,userid);
//		} catch (AlipayApiException e) {
//			e.printStackTrace();
//		} finally{
//			logger.info("alirefund 关闭连接");
//			SQLHelper.close(rs);
//		}
//		response.getWriter().write(jsonobj.toString());
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}
//}
