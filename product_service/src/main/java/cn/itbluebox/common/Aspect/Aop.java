//package cn.itbluebox.common.Aspect;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//
//@Aspect//定义这是一个切面类
//@Configuration//注入
//public class Aop {
//    private static final Logger LOGGER = LoggerFactory.getLogger(Aop.class);
//
//
//    /**
//     * 定义切点
//     */
//    @Pointcut(value = "execution(* cn.itbluebox.product.controller.*.*(..))")
//    public void point() {
//    }
//
//    /**
//     * 定义前置通知
//     */
//    @Before("point()")
//    public void adviceBefore() {
//        LOGGER.info("前置通知触发");
//        //获取所有的请求url和请求的ip地址
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//
//        String uri = request.getRequestURI();
//        String method = request.getMethod();
//        String ip = request.getRemoteHost();
////        LOGGER.info("请求的url:{},method:{},ip:{}", uri, method, ip);
//        System.out.println("这里写前置方法");
//    }
//
//    @After("point()")
//    public void adviceAfter() {
//        LOGGER.info("后置通知触发");
//        //获取所有的请求url和请求的ip地址
//        System.out.println("这里写后置方法");
//    }
//
//
//    /**
//     * @param proceedingJoinPoint 环绕通知的正在执行中的连接点（这是环绕通知独有的参数）
//     * @return 目标方法执行的返回值
//     * @Around: 环绕通知，有返回值，环绕通知必须进行放行方法（就相当于拦截器），否则目标方法无法执行
//     */
//    @Around("point()")
//    public Object aroud(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        System.out.println("aroud环绕通知开始.......");
//        System.out.println("执行的目标类 = " + proceedingJoinPoint.getTarget());
//        System.out.println("执行的目标方法 = " + proceedingJoinPoint.getSignature().getName());
//        // 必须方法目标方法
//        Object proceed = proceedingJoinPoint.proceed();
//        System.out.println("获得方法的返回值"+proceed);
//        System.out.println("在这里可以处理返回值");
//        Class<?> aClass = proceed.getClass();
//        System.out.println();
//        System.out.println("aroud环绕通知结束.......");
//        // 将目标方法的返回值进行返回，否则调用目标方法的方法无法获取到返回值
//        return proceed;
//    }
//
//
//}
