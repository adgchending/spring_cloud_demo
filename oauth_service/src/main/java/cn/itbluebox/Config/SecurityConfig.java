package cn.itbluebox.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @类名:SecurityConfig
 * @类描述:SecurityConfig配置类
 * @创建日期: 2022/4/21
 * @修改记录:
 * <pre>
 *    修改日期：
 *    版 本 号：
 *    修 改 人：
 *    修改内容：
 * </pre>
 * @author: csx
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //自定义登录页面,如果不重写此方法,则会使用security的默认登录页面
    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.formLogin().loginPage("/login.html");
    }


    @Bean
    public PasswordEncoder gerPw(){
        return new BCryptPasswordEncoder();
    }
}
