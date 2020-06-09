package com.osiris.account.service;

import com.osiris.account.entity.User;

/**
 * 登陆服务
 *
 * @author : 李佳
 */
public interface LoginService {

    /**
     * 账号登陆
     */
    Boolean loginByAccount(User user) throws Exception;

    /**
     * 注册
     */
    Boolean register(User user) throws Exception;

    /**
     * 更新用户信息
     */
    Boolean updateUser(User user);

}
