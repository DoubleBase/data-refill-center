package com.muskmelon.data.refill.center.config;

import com.alibaba.druid.pool.xa.DruidXADataSource;
import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Getter;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.sql.DataSource;
import javax.transaction.UserTransaction;

/**
 * @author muskmelon
 * @since 1.0
 */
@Configuration
@MapperScan(value = "com.muskmelon.data.refill.center.mapper.activity",
        sqlSessionFactoryRef = "activitySqlSessionFactory")
public class ActivityDataSourceConfig {

    @Value("${activity.datasource.url}")
    private String url;
    @Value("${activity.datasource.username}")
    private String userName;
    @Value("${activity.datasource.password}")
    private String password;
    @Value("${activity.datasource.driver-class-name}")
    private String driverName;


    @Bean(name = "activityDataSource")
    public DataSource dataSource() {
        DruidXADataSource dataSource = new DruidXADataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverName);
        AtomikosDataSourceBean atomikosDataSource = new AtomikosDataSourceBean();
        atomikosDataSource.setXaDataSource(dataSource);
        atomikosDataSource.setUniqueResourceName("activityDataSourceResource");
        return atomikosDataSource;
    }

//    @Bean(name = "activityTransactionManager")
//    public DataSourceTransactionManager dataSourceTransactionManager() {
//        return new DataSourceTransactionManager(dataSource());
//    }

    @Bean(name = "xata")
    @Primary
    public JtaTransactionManager activityTransactionManager() {
        UserTransactionManager userTransactionManager = new UserTransactionManager();
        UserTransaction userTransaction = new UserTransactionImp();
        return new JtaTransactionManager(userTransaction, userTransactionManager);
    }

    @Bean(name = "activitySqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(
            @Qualifier("activityDataSource") DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();
    }



}
