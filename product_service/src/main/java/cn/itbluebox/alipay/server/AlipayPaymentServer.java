//package cn.itbluebox.alipay.server;
//
//public class AlipayPaymentServer {
//    /** API调用客户端 */
//    private static AlipayClient alipayClient;
//
//    /**
//     * 获得API调用客户端
//     *
//     * @return
//     */
//    public static AlipayClient getAlipayClient(){
//
//        if(null == alipayClient){
//            alipayClient = new DefaultAlipayClient(AlipayPaymentConfig.ALIPAY_GATEWAY, AlipayPaymentConfig.APP_ID,
//                    AlipayPaymentConfig.PRIVATE_KEY, "json", AlipayPaymentConfig.CHARSET, AlipayPaymentConfig.ALIPAY_PUBLIC_KEY, AlipayPaymentConfig.SIGN_TYPE);
//        }
//        return alipayClient;
//    }
//}
