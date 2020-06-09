package com.osiris.account.service.Impl;

import com.osiris.account.constant.AccountConstants;
import com.osiris.account.entity.User;
import com.osiris.account.mapper.UserDao;
import com.osiris.account.service.LoginService;
import com.osiris.account.util.EncryptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

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
     * @param user 用户信息
     */
    public Boolean loginByAccount(User user) throws Exception {
        validateNull(user.getAccount(),user.getPassword());
        user.setPassword(EncryptionUtils.getMd5BySpring(user.getPassword()));
        securityValidate(user);
        return dologin(user);
    }

    /**
     * 注册
     *
     * @param user 用户信息
     */
    @Transactional(rollbackFor = Exception.class)
    public Boolean register(User user) throws Exception {
        validateNull(user,user.getAccount(),user.getPassword(),user.getUserName(),user.getEmail());
        user.setPassword(EncryptionUtils.getMd5BySpring(user.getPassword()));
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setStatus(AccountConstants.USER_STATUS_NOT_ACTIVE);
        int iline = userDao.insert(user);
        if (iline!=1){
            throw new Exception("注册失败");
        }
        LOGGER.info("{}账号:{},注册成功",user.getUserName(),user.getAccount());
        //todo 异步发送激活邮件
        return true;
    }

    /**
     * 更新用户信息
     *
     * @param user 用户信息
     */
    public Boolean updateUser(User user) {
        userDao.update(user);
        return true;
    }

    private Boolean dologin(User user) throws Exception {
        List<User> users = userDao.queryAll(user);
        if (CollectionUtils.isEmpty(users)||users.size()>1){
            return false;
        }
        User userNew = new User();
        userNew.setId(users.get(0).getId());
        userNew.setLoginIp(user.getLoginIp());
        int iline =  userDao.update(userNew);
        if (iline!=1){
            throw new Exception("login fail");
        }
        LOGGER.info("user {} login",users.get(0).getAccount());
        return true;
    }

    private void validateNull(Object... objs) throws Exception {
        for (Object o : objs) {
            if (o==null){
                throw new Exception("params is null");
            }
            if (o instanceof String){
                if (StringUtils.isEmpty(o)){
                    throw new Exception("Strings is empty");
                }
            }
        }

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
