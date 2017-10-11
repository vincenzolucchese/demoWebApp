package com.vince.boot.demo.webapp.config;
/*****************************************
 * managing config about embedded database
 *****************************************/
//package com.vince.config;
//
//import javax.sql.DataSource;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.JdbcOperations;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
//
//@Configuration
//public class DataConfig {
//
//  @Bean
//  public DataSource dataSource() {
//    return new EmbeddedDatabaseBuilder()
//            .setType(EmbeddedDatabaseType.HSQL)
//            .addScript("/db/hsqldb/schema.sql")
//            .build();
//  }
//  
//  @Bean
//  public JdbcOperations jdbcTemplate(DataSource dataSource) {
//    return new JdbcTemplate(dataSource);
//  }
//
//		@Bean
//		public DataSource dataSource() {
//		    PoolConfig poolConfig = new PoolConfig(5, 30, 3000);
//		    DataSourceConfig dbConfig = new DataSourceConfig(poolConfig, null);
//		    return connectionFactory().dataSource("my-own-personal-sql", dbConfig);
//		}
//
//}
