package cn.itbluebox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder pw;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //1查询数据库判断用户名是否存在,不存在则抛出异常
        if (!"admin".equals(username)) {
            throw new UsernameNotFoundException("用户不存在");
        }

        //2把查询出来的密码(注册时已经加密的)进行解析,或者把密码放入构造方法
        //encode方法是给密码加盐
        String password = pw.encode("123");

        //放入帐号,密码,权限
        return new User(username, password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin,normal"));
    }
}
