package com.osiris.account.service;

/**
 * 登陆服务
 *
 * @author : 李佳
 */
public interface LoginService {

    /**
     * 账号登陆
     */
    void loginByAccount(String account, String password);

}
