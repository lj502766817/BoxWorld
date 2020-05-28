package com.osiris.account.configuration.mybatis;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * 连接池配置
 *
 * @author : 李佳
 */
@Configuration
@PropertySource("classpath:jdbc.properties")
public class DataSourceConfig {

    @Value("${jdbc.connectionURL}")
    private String url;
    @Value("${jdbc.userName}")
    private String userName;
    @Value("${jdbc.decryptPassword}")
    private String password;
    @Value("${jdbc.druidPath}")
    private String druidPath;

    /**
     * 慢sql配置
     */
    @Bean
    public Filter statFilter(){
        StatFilter statFilter = new StatFilter();
        statFilter.setSlowSqlMillis(2000);
        statFilter.setLogSlowSql(true);
        return statFilter;
    }

    @SuppressWarnings("ContextJavaBeanUnresolvedMethodsInspection")
    @Bean(name = "dataSourceOsiris",initMethod = "init", destroyMethod = "close")//这里的init和close方法都是在druid源码里面的方法
    public DataSource dataSourceMaster() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(userName);
        druidDataSource.setPassword(password);
        druidDataSource.setUrl(url);
        druidDataSource.setConnectionProperties("config.file=file://"+druidPath);
        druidDataSource.setFilters("config,stat,mergeStat");
        druidDataSource.setMaxActive(20);
        druidDataSource.setInitialSize(20);
        druidDataSource.setMaxWait(60000);
        druidDataSource.setMinIdle(1);
        druidDataSource.setTimeBetweenEvictionRunsMillis(60000);
        druidDataSource.setMinEvictableIdleTimeMillis(300000);
        druidDataSource.setValidationQuery("SELECT 'x'");
        druidDataSource.setTestWhileIdle(true);
        druidDataSource.setTestOnBorrow(false);
        druidDataSource.setTestOnReturn(false);
        druidDataSource.setPoolPreparedStatements(false);
        druidDataSource.setMaxOpenPreparedStatements(20);
        druidDataSource.setProxyFilters(Arrays.asList(statFilter()));
        druidDataSource.setConnectionErrorRetryAttempts(5);
        return druidDataSource;
    }

    /**
     * 必须加上static
     */
//    @Bean  这个还不知道是干嘛用的,貌似是用来读取properties文件的
//    public static PropertySourcesPlaceholderConfigurer loadProperties() {
//        return new PropertySourcesPlaceholderConfigurer();
//    }

}
