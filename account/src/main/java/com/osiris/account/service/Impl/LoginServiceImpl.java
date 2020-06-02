package com.osiris.account.service.Impl;

import com.osiris.account.entity.User;
import com.osiris.account.mapper.UserDao;
import com.osiris.account.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : 李佳
 */
@Service
public class LoginServiceImpl implements LoginService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private UserDao userDao;

    /**
     * 账号登陆
     *
     * @param account 账号
     * @param password 密码
     */
    public void loginByAccount(String account, String password) {
        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        securityValidate(user);
    }

    /**
     * 安全验证
     * @param user 用户
     */
    private void securityValidate(User user) {
        //todo 频率检测,密码重试次数
        if (user.getAccount()!=null){
            System.out.println("账户的安全验证");
        }
    }
}
