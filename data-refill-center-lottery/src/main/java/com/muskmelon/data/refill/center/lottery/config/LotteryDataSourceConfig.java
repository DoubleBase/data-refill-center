package com.muskmelon.data.refill.center.lottery.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.xa.DruidXADataSource;
import com.atomikos.jdbc.AtomikosDataSourceBean;
import lombok.Getter;
import org.apache.ibatis.session.SqlSessionFactory;
import org.bytesoft.bytejta.supports.jdbc.LocalXADataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author muskmelon
 * @since 1.0
 */
@Getter
@Configuration
@MapperScan(value = "com.muskmelon.data.refill.center.mapper.lottery",
        sqlSessionFactoryRef = "lotterySqlSessionFactory")
public class LotteryDataSourceConfig {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String userName;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.driver-class-name}")
    private String driverName;


    @Bean(name = "lotteryDataSource")
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverName);

        LocalXADataSource localXADataSource = new LocalXADataSource();
        localXADataSource.setDataSource(dataSource);
        return localXADataSource;
    }

    @Bean(name = "lotteryTransactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean(name = "lotterySqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(
            @Qualifier("lotteryDataSource") DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();
    }


}
