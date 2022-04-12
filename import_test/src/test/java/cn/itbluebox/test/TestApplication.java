package cn.itbluebox.test;

import cn.itbluebox.bean.EnableUserBean;
import cn.itbluebox.bean.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@EnableUserBean
public class TestApplication {

    public static void main(String[] args) {

        //获取Spring容器
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestApplication.class);
        User user = ac.getBean(User.class);
        System.out.println(user);

    }

}

