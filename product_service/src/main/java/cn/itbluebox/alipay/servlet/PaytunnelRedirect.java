//package cn.itbluebox.alipay.servlet;
//
//import com.alipaypayment.model.AlipayPaymentConfig;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Map;
//
///**
// * 支付宝支付入口
// */
//@WebServlet("/mporder")
//public class PaytunnelRedirect extends HttpServlet {
//
//    private static final long serialVersionUID = 1L;
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=utf-8");
//
//        String state = request.getParameter("state");
//        String appid = AlipayPaymentConfig.APP_ID;
//        String ENCODED_URL = "http%3a%2f%2fwx.wing-cafe.com%2fpay%2falipaybaseauthservlet";
//
//        response.sendRedirect("https://openauth.alipay.com/oauth2/publicAppAuthorize.htm?app_id="+appid+"&auth_skip=false&scope=auth_base&redirect_uri="+ENCODED_URL+"&state="+state);
//
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request, response);
//    }
//}
