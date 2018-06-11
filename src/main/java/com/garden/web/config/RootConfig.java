package com.garden.web.config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * 数据层组件配置类
 * @author Garden
 * 2018年3月25日
 */
@Configuration
@ComponentScan(basePackages={"com.garden.web.dao","com.garden.web.service"},
               excludeFilters={@Filter(type=FilterType.ANNOTATION,value=EnableWebMvc.class)}) 
@ImportResource("classpath:spring-config.xml")
public class RootConfig {
	
	//获取数据源配置数据
	@Bean
	public Properties properties() throws IOException{
		InputStream in = RootConfig.class.getClassLoader().getResourceAsStream("database.properties");
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
	
	//配置事务管理
	@Bean
	public DataSourceTransactionManager transactionManager(DruidDataSource dataSource){
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource);
		return transactionManager;
	}
	
	//Spring与Mybatis整合
	@Bean
	public SqlSessionFactory sqlSessionFactory(DruidDataSource dataSource) throws Exception{
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		InputStream in = RootConfig.class.getClassLoader().getResourceAsStream("mapper-name.properties");
		Properties properties = new Properties();
		properties.load(in);
		String mapperNames = properties.getProperty("mapper.names");
		String[] mapperNameArr = mapperNames.split(",");
		InputStreamResource[] mapperLocations = new InputStreamResource[mapperNameArr.length];
		for(int i = 0; i < mapperNameArr.length; i++){
			InputStream ins = RootConfig.class.getClassLoader().getResourceAsStream("mybatis-mapper/"+mapperNameArr[i]+".xml");
			mapperLocations[i] = new InputStreamResource(ins);
		}
		sqlSessionFactoryBean.setMapperLocations(mapperLocations);	
		InputStream in1 = RootConfig.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
		InputStreamResource configLocation = new InputStreamResource(in1);
		sqlSessionFactoryBean.setConfigLocation(configLocation);
		return sqlSessionFactoryBean.getObject();
	}
	
	//配置Mybatis模板
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
		return new SqlSessionTemplate(sqlSessionFactory);	
	}
	
}
