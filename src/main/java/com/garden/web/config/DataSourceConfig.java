package com.garden.web.config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class DataSourceConfig {
	
	//获取数据源配置数据
	@Bean
	public Properties properties() throws IOException{
		InputStream in = DataSourceConfig.class.getClassLoader().getResourceAsStream("database.properties");
		Properties properties = new Properties();
		properties.load(in);
		return properties;
	}
	
	//配置数据源
	@Bean
	public DruidDataSource dataSource(Properties properties) throws SQLException{
	  DruidDataSource druidDataSource = new DruidDataSource ();
	  druidDataSource.setUrl(properties.getProperty("database.url"));
	  druidDataSource.setUsername(properties.getProperty("database.user"));
	  druidDataSource.setPassword(properties.getProperty("database.password"));
	  druidDataSource.setName(properties.getProperty("database.name"));
	  druidDataSource.setFilters(properties.getProperty("database.filters"));
	  druidDataSource.setMaxActive(Integer.parseInt(properties.getProperty("database.maxActive")));
	  druidDataSource.setInitialSize(Integer.parseInt(properties.getProperty("database.initialSize")));
	  druidDataSource.setMaxWait(Integer.parseInt(properties.getProperty("database.maxWait")));
	  druidDataSource.setMinIdle(Integer.parseInt(properties.getProperty("database.minIdle")));
	  druidDataSource.setTimeBetweenConnectErrorMillis(Integer.parseInt(properties.getProperty("database.timeBetweenConnectErrorMillis")));
	  druidDataSource.setMinEvictableIdleTimeMillis(Integer.parseInt(properties.getProperty("database.minEvictableIdleTimeMillis")));
	  druidDataSource.setValidationQuery(properties.getProperty("database.validationQuery"));
	  druidDataSource.setTestWhileIdle(Boolean.parseBoolean(properties.getProperty("database.testWhileIdle")));
	  druidDataSource.setTestOnBorrow(Boolean.parseBoolean(properties.getProperty("database.testOnBorrow")));
	  druidDataSource.setTestOnReturn(Boolean.parseBoolean(properties.getProperty("database.testOnReturn")));
	  druidDataSource.setPoolPreparedStatements(Boolean.parseBoolean(properties.getProperty("database.poolPreparedStatements")));
	  druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(Integer.parseInt(properties.getProperty("database.maxPoolPreparedStatementPerConnectionSize")));
	  return druidDataSource;
	}
}
