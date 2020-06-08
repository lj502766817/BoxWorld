package com.osiris.account;

import com.alibaba.fastjson.JSON;
import com.osiris.account.mapper.UserDao;
import com.osiris.account.entity.User;
import com.osiris.account.util.RedisUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountApplicationTest {

    @Before
    public void init() {
        System.out.println("开始测试-----------------");
    }

    @After
    public void after() {
        System.out.println("测试结束-----------------");
    }

    @Autowired
    private UserDao userDao;

    @Test
    public void test(){
        User o = userDao.queryById(0);
        System.out.println(JSON.toJSONString(o));
    }

    @Test
    public void test1(){
        RedisUtils.setStr("111","aaaa",20);
    }

}