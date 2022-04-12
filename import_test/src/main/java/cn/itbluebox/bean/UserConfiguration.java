package cn.itbluebox.bean;

import org.springframework.context.annotation.Bean;

/*
没有Spring注解
 */
public class UserConfiguration {
    @Bean
    public User getUser(){
        User user = new User();
        user.setAge(12);
        user.setUsername("张三");
        return user;
    }
}

