package com.osiris.account.util;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加密工具
 *
 * @author : 李佳
 */
public class EncryptionUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(EncryptionUtils.class);

    private static final String PREFIX = "Osiris";

    private static final String SUFFIX = "lj";

    /**
     * 手动封装的md5加密
     * @param str 需要加密的串
     * @return 加密后的结果
     */
    public static String getMd5Str(String str){
        byte[] digest = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            digest  = md5.digest(str.getBytes("utf-8"));
        } catch (NoSuchAlgorithmException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
        } catch (UnsupportedEncodingException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
        }
        //16是表示转换为16进制数
        return new BigInteger(1, digest).toString(16);
    }

    /**
     * spring封装的md5加密,加密串拼上了常量,防止被破解得到原串
     * @param str
     * @return
     */
    public static String getMd5BySpring(String str){
        return DigestUtils.md5DigestAsHex((PREFIX+str+SUFFIX).getBytes());
    }

}
