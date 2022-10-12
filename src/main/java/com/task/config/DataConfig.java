package com.task.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.task.config.info.JdbcInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
public class DataConfig {
    @Resource
    private JdbcInfo jdbcInfo;

    @Bean
    public DataSource getDataSource(){
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setUrl(jdbcInfo.getUrl());
        dataSource.setDriverClassName(jdbcInfo.getDriver());
        dataSource.setUsername(jdbcInfo.getUsername());
        dataSource.setPassword(jdbcInfo.getPassword());
        return dataSource;
    }
    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
    /*@Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage(jdbcInfo.getTypeAliasesPackage());

        return sqlSessionFactoryBean;
    }*/


}
