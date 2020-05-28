package com.osiris.account.configuration.mybatis;

import org.apache.ibatis.logging.slf4j.Slf4jImpl;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * mybatis配置, proxyTargetClass = true 表示使用cglib的代理方式,false表示使用jvm的默认代理方式
 *
 * @author : 李佳
 */
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@MapperScan("com.osiris.account.mapper")
public class MybatisConfig {

    @Autowired
    @Qualifier("dataSourceOsiris")
    public DataSource dataSource;

    @Lazy(value = false)
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory localSqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
        sqlSessionFactory.getConfiguration().setLogImpl(Slf4jImpl.class);
        return sqlSessionFactory;
    }

    @Bean(name = "txManager")
    public DataSourceTransactionManager dataSourceTransactionManager(){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }

}
