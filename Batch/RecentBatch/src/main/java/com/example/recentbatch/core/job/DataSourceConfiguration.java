package com.example.recentbatch.core.job;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.support.JdbcTransactionManager;

import javax.sql.DataSource;
//
//@Configuration
//public class DataSourceConfiguration {
//    @Bean
//    public DataSource batchDataSource() {
//        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL)
//                .addScript("/org/springframework/batch/core/schema-hsqldb.sql")
//                .generateUniqueName(true).build();
//    }
//
//    @Bean
//    public JdbcTransactionManager batchTransactionManager(DataSource dataSource) {
//        return new JdbcTransactionManager(dataSource);
//    }
//}
