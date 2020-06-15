package com.osiris.character.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 人物表(Character)实体类
 *
 * @author makejava
 * @since 2020-06-15 20:48:56
 */
public class Character implements Serializable {
    private static final long serialVersionUID = -76564329438824673L;
    
    private Integer id;
    /**
    * 用户id
    */
    private Integer userId;
    /**
    * 角色名称
    */
    private String name;
    /**
    * 状态 0:死亡,1:正常
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

}