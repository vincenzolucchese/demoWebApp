package com.vince.boot.demo.webapp.config;
/*****************************************
 * managing config about cloud foundry
 *****************************************/
//package com.vince.boot.demo.config;
//
//import javax.sql.DataSource;
//
//import org.springframework.cloud.config.java.AbstractCloudConfig;
//import org.springframework.cloud.service.PooledServiceConnectorConfig;
//import org.springframework.cloud.service.relational.DataSourceConfig;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//
//@Configuration
//@Profile("cloud")
//public class CloudConfig extends AbstractCloudConfig {
//	@Bean
//	DataSource dataSource() {
//		PooledServiceConnectorConfig.PoolConfig poolConfig = new PooledServiceConnectorConfig.PoolConfig(
//				1 /* min */, 2 /* max */, 3000 /* maxWait */);
//		return connectionFactory().dataSource(new DataSourceConfig(poolConfig, null));
//	}
//}