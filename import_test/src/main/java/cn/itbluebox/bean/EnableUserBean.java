package cn.itbluebox.bean;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.TYPE)  //设置当前注解是可以配置到类上的注解
@Import(UserImportSelector.class)
public @interface EnableUserBean {
}

