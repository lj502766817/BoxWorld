package com.osiris.account;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;


@SpringBootTest
class ServerApiApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testFtp() {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect("129.28.161.161", 21);
            ftpClient.login("anonymous", null);
            int replyCode = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replyCode)){
                throw new Exception("登陆失败");
            }
            if (!ftpClient.changeWorkingDirectory("/pub")){
                throw new Exception("切换工作目录失败");
            }
            OutputStream os = new ByteArrayOutputStream();
            ftpClient.retrieveFile("/pub",os);
            System.out.println(os);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ftpClient.logout();
                ftpClient.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
