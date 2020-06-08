package com.osiris.account.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import redis.clients.jedis.Jedis;

import java.io.FileNotFoundException;
import java.util.ResourceBundle;

/**
 * redis工具类
 *
 * @author : 李佳
 */
public class RedisUtils {

    private static String host;
    private static String port;

    private static Jedis jedis;

    static {
        ResourceBundle resource = ResourceBundle.getBundle("redis");
        host = resource.getString("redis.host");
        port = resource.getString("redis.port");
        //连接本地的 Redis 服务
        jedis = new Jedis(host,Integer.parseInt(port));
        jedis.auth(resource.getString("redis.pwd"));
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
    }

    public RedisUtils() throws FileNotFoundException {
        if (StringUtils.isAnyBlank(host,port)){
            throw new FileNotFoundException("host or port is not exist");
        }
    }

    /**
     * 向redis里进行字符串设值
     * @param key 键
     * @param value 值
     * @param seconds 过期时间(秒)
     */
    public static void setStr(String key, String value, Integer seconds){
        jedis.set(key,value);
        jedis.expire(key,seconds);
    }

}
