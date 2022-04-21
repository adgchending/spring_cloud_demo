//package cn.itbluebox.alipay.servlet;
//
//import com.alipaypayment.model.AlipayPaymentConfig;
//import com.alipaypayment.server.AlipayPaymentServer;
//import com.alipay.api.AlipayApiException;
//import com.alipay.api.AlipayClient;
//import com.alipay.api.request.AlipaySystemOauthTokenRequest;
//import com.alipay.api.response.AlipaySystemOauthTokenResponse;
//import com.df.util.RequestUtil;
//import com.wx.model.PageInfo;
//import com.wx.server.AuthdenyPage;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Map;
//
///**
// * 重定向数据库存储过程拉取指向地址(支付宝)
// */
//@WebServlet("/alipaybaseauthservlet")
//public final class AlipayBaseAuthServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//1. 解析请求参数
//        Map<String, String> mpparams = RequestUtil.getRequestParams(request);
//        //2. 获得authCode
//        String authCode = mpparams.get("auth_code");
//        String state = mpparams.get("state");
//        System.out.println("zhifubaocode----"+authCode);
//        System.out.println("state----"+state);
//        try {
//            //3. 利用authCode获得authTokenx
//            AlipaySystemOauthTokenRequest oauthTokenRequest = new AlipaySystemOauthTokenRequest();
//            oauthTokenRequest.setCode(authCode);
//            oauthTokenRequest.setGrantType(AlipayPaymentConfig.GRANT_TYPE);
//            AlipayClient alipayClient = AlipayPaymentServer.getAlipayClient();
//            AlipaySystemOauthTokenResponse oauthTokenResponse = alipayClient
//                .execute(oauthTokenRequest);
//
//            String openId = oauthTokenResponse.getUserId();
//            System.out.println("openid------>"+openId);
//
//    		String params = "openId="+openId;
//
//            PageInfo pageInfo = AuthdenyPage.GetPage(state, openId);
//
//    		if (pageInfo.getFlag().equals("1")) {
//    			if (pageInfo.getRespType().equals("sendRedirect")) {
//    				response.sendRedirect(pageInfo.getUrl() + params);
//    			} else {
//    				request.getRequestDispatcher(pageInfo.getUrl() + params).forward(
//    						request, response);
//    			}
//    		} else {
//    			request.getRequestDispatcher("error.jsp").forward(request,
//    					response);
//    		}
//        } catch (AlipayApiException alipayApiException) {
//            //自行处理异常
//            alipayApiException.printStackTrace();
//        }
//
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}
//
//	public static void main(String[] args) throws AlipayApiException {
//		String authCode = "9da3dbc2020e4cdc97d3ef5fd39dZA09";
//		 AlipaySystemOauthTokenRequest oauthTokenRequest = new AlipaySystemOauthTokenRequest();
//         oauthTokenRequest.setCode(authCode);
//         oauthTokenRequest.setGrantType(AlipayPaymentConfig.GRANT_TYPE);
//         AlipayClient alipayClient = AlipayPaymentServer.getAlipayClient();
//         AlipaySystemOauthTokenResponse oauthTokenResponse = alipayClient.execute(oauthTokenRequest);
//
//         String openId = oauthTokenResponse.getUserId();
//         System.out.println("openid------>"+openId);
//
//
//	}
//}
