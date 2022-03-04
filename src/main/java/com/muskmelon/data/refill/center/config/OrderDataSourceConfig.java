package com.muskmelon.data.refill.center.config;

import com.alibaba.druid.pool.xa.DruidXADataSource;
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

import javax.sql.DataSource;

/**
 * @author muskmelon
 * @since 1.0
 */
@Getter
@Configuration
@MapperScan(value = "com.muskmelon.data.refill.center.mapper.order",
        sqlSessionFactoryRef = "orderSqlSessionFactory")
public class OrderDataSourceConfig {

    @Value("${order.datasource.url}")
    private String url;
    @Value("${order.datasource.username}")
    private String userName;
    @Value("${order.datasource.password}")
    private String password;
    @Value("${order.datasource.driver-class-name}")
    private String driverName;


    @Bean(name = "orderDataSource")
    @Primary
    public DataSource dataSource() {
        DruidXADataSource dataSource = new DruidXADataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverName);

        AtomikosDataSourceBean atomikosDataSource = new AtomikosDataSourceBean();
        atomikosDataSource.setXaDataSource(dataSource);
        atomikosDataSource.setUniqueResourceName("orderDataSourceResource");
        return atomikosDataSource;
    }

//    @Bean(name = "orderTransactionManager")
//    @Primary
//    public DataSourceTransactionManager dataSourceTransactionManager() {
//        return new DataSourceTransactionManager(dataSource());
//    }

    @Bean(name = "orderSqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(
            @Qualifier("orderDataSource") DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();
    }

    

}
