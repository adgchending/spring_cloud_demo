//package cn.itbluebox.alipay.model;
//
//public class AlipayPaymentConfig {
//
//    /**
//     * 支付宝公钥-从支付宝服务窗获取
//     */
//    public static final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmwG3NC4c21LVr1h6TJWnJt21eaiRHU2pAVL+RoJs2lUZYQ9TIhLlK0grkyMEkTY/TkX8zgy1hjI8Efg8PTmGN4TxL1cXO0EFrhx8bVh9rHOCMZfgzgSO6P0BVMNtExfG7GmGGgNo57TS3DJ2m1gvYUVV49KERcLdknu1XftBt/vzVsN1Mvhpzt3MQ/S2gdcEpWiTgy234LkQXAd4ON6R/AC2lUKNgxx00o4jVg1RPr/d1aQj4D37P9kkF2R3s8Wwv0RQswAZc8FL/MxIH1IomAVGutNJuWjvqqIgZp++0uiRAoM7oXinF5lYuMJCIRO9reGK/5SmcsOyzZRRYJS6vQIDAQAB";
//    /**
//     * 签名编码-视支付宝服务窗要求
//     */
//    public static final String SIGN_CHARSET = "UTF-8";
//
//    /**
//     * 字符编码-传递给支付宝的数据编码
//     */
//    public static final String CHARSET = "UTF-8";
//
//    /**
//     * 签名类型-视支付宝服务窗要求
//     */
//    public static final String SIGN_TYPE = "RSA2";
//
//    /**
//     * 合作身份者ID，签约账号，以2088开头由16位纯数字组成的字符串
//     */
//    public static final String PARTNER = "2088341900786206";
//
//    public static final String SELLER_ID = PARTNER;
//
//    /**
//     * 服务窗appId
//     */
//    //TODO !!!! 注：该appId必须设为开发者自己的服务窗id  这里只是个测试id
//    public static final String APP_ID = "2021003124694161";      //2019032663720286
//
//    //开发者请使用openssl生成的密钥替换此处  请看文档：https://fuwu.alipay.com/platform/doc.htm#2-1接入指南
//    //TODO !!!! 注：该私钥为测试账号私钥  开发者必须设置自己的私钥 , 否则会存在安全隐患
//    public static final String PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCbAbc0LhzbUtWvWHpMlacm3bV5qJEdTakBUv5GgmzaVRlhD1MiEuUrSCuTIwSRNj9ORfzODLWGMjwR+Dw9OYY3hPEvVxc7QQWuHHxtWH2sc4Ixl+DOBI7o/QFUw20TF8bsaYYaA2jntNLcMnabWC9hRVXj0oRFwt2Se7Vd+0G3+/NWw3Uy+GnO3cxD9LaB1wSlaJODLbfguRBcB3g43pH8ALaVQo2DHHTSjiNWDVE+v93VpCPgPfs/2SQXZHezxbC/RFCzABlzwUv8zEgfUiiYBUa600m5aO+qoiBmn77S6JECgzuheKcXmVi4wkIhE72t4Yr/lKZyw7LNlFFglLq9AgMBAAECggEALuKK9paIFfLtPXdmrqmJgKEJFj5dfl6SIxtmXA9xO20IGyqWe7T5amkO/RdXd1DQPy2+NNj1Qx0IvGq4VdCDf2GPzkDqfvrA7BQjsrNUeAgMNlH5JneMfn6gm3HtGRxVCAc3D8E+Ru+T5BTDeWNoGWTugNWZOryhZoBSsJWiIDL1oMBvcvxAxu04n+0GS/SgAzgX7I1G9smh0Qw2A7WPSJimHo7DqTn+H0BZYoSu1Zrm7Ny1rDf0BBhdVfiI/FdWhowkCyO7xZ5SV44k8aD8/EKu8CRIeYedvKt1WhTI3N1jzHpMT58CyLcxXpnxTILoDpXsX87gAaYC4Os3Y+tLYQKBgQDPijfTZBU9JWrgCNZY7MPxAPG8jsSNx2j2O/vH9gRhi06l7Q1jYm2IdRxQQUkM2XIgtixgz/FXEsiZYWmdhaf395AMfiz/0P+mI3cAbSjf25pzQ/tYGNn1K1h2awRQP+Cq+P4yFzlIOl5pEP6wuzv6OqiYQjJ29/laycYDvKLPiQKBgQC/M027NIOIxviUHWT6X/9vO4wRpFBS17ao2FuqegB3nyzLEnsbBKAAtvx6IRK3iSuI7SiQizxAAx00h4qxNGazwga0IYH5RJwrzC4axSIb17w8M46ltNvNW6roiF8FBHd7fvlR/YDhKPW9gwTMoTul70Bmd9zZCZv80/UKy1ZwlQKBgQCnfjodrWkCpx8A3cD3lWVxLDzr2yC/9447Ix/JOkBA5Oe9O3oRmk8h0Lnf/0BQUXEs+zkHjOqORkeEmbxd948erTohCveQIYEg+QBCZNaXC6kzm0rOx4enuKq1LxsVFOhhs3+at2lwZELrcl7KDOGTyiFkeBA4OVqRrcPUIjoXWQKBgQCfKrlR15SMH3895f5yw8mjsoGXCh9n53WCt6IPl8Kd0l96qebbhg0gqzQhAzlOmp0oPq1fLtm4PB9q5E7b19CLYkEsYRyPAsOzXiUfWe5cGUr1HsJoRdgY62+qZiQbzC0fHIO28n8AcZWo7tHm+23pY/NLmgq6jtpRLa23D7DkxQKBgB+8UozhgB1GbdXpHfhUNHo1nrF6a3qFm6AobhHF/nzMDihsCAcUbMoX8AyN+TyTvSXV6jlzvsEIAc//gYqe5xmbijFG17LVuisPrGzhNn0u0+8u+5QVBINhp+1inwjAKvSBBxrOJA2kPsBQcCQ+3zhUCSJ8uQlFcYIQm8Bnjkde";
//
//    //TODO !!!! 注：该公钥为测试账号公钥  开发者必须设置自己的公钥 ,否则会存在安全隐患
////    public static final String PUBLIC_KEY        = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC2yD6STf4ljk3e6Vkpj5BJhD4X 1iLPXAuOGSocrsk9ya931yTkGAbBh+EcJ195y2WEJhcvkVdra5JykdBKecuxxX+A 1xPP0p5ReVchgm1olH4FxOn43VW/jWZLBZxIcRzBw47p0/0Sa1G1VTE4r/NM0cDX kM6M8DczPhWs+qbwHwIDAQAB";
//
//    /**
//     * 支付宝网关
//     */
//    public static final String ALIPAY_GATEWAY = "https://openapi.alipay.com/gateway.do";
//
//    /**
//     * 授权访问令牌的授权类型
//     */
//    public static final String GRANT_TYPE = "authorization_code";
//
//    public static final String SCOPE = "auth_base";
//
//    public static final String AUTH_SKIP = "false";
//
//}
