package com.osiris.account.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户账户表(User)实体类
 *
 * @author makejava
 * @since 2020-05-26 22:11:13
 */
public class User implements Serializable {
    private static final long serialVersionUID = -13567218383110676L;
    /**
    * 主键
    */
    private Integer id;
    /**
    * 用户名
    */
    private String userName;
    /**
    * 用户账户
    */
    private String account;
    /**
    * 用户密码
    */
    private String password;
    /**
    * 用户手机号
    */
    private Double phone;
    /**
     * 邮箱
     */
    private String email;
    /**
    * 登陆ip
    */
    private String loginIp;
    /**
     * 账号状态 0:冻结,1,正常,2未激活
     */
    private Integer status;
    
    private Date createTime;
    
    private Date updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getPhone() {
        return phone;
    }

    public void setPhone(Double phone) {
        this.phone = phone;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}