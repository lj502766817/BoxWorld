package com.osiris.account.util;

import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.Jedis;

import java.io.FileNotFoundException;
import java.util.List;
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
     * @param str 字符串
     * @param seconds 过期时间(秒)
     */
    public static void setStr(String key, String str, Integer seconds){
        jedis.set(key,str);
        jedis.expire(key,seconds);
    }

    /**
     * 字符串附加
     * @param key 键
     * @param appendStr 附加字符串
     * @param seconds 过期时间
     */
    public static void appendStr(String key, String appendStr, Integer seconds){
        jedis.append(key,appendStr);
        jedis.expire(key,seconds);
    }

    /**
     * 字符串唯一设值,key存在时失败
     * @param key 键
     * @param str 字符串
     * @param seconds 过期时间
     * @return 设值成功或者失败
     */
    public static Boolean setStrNx(String key, String str, Integer seconds) {
        long result = jedis.setnx(key,str);
        jedis.expire(key,seconds);
        return result==1;
    }

    /**
     * 设置字符串集合
     * @param key 键
     * @param strs 字符串集合
     * @param seconds 过期时间
     */
    public static void setStrList(String key, List<String> strs, Integer seconds){
        for (String str : strs) {
            jedis.lpush(key,str);
        }
        jedis.expire(key,seconds);
    }

}
