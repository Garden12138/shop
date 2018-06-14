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
import org.springframework.context.annotation.Import;
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
@Import({UtilsConfig.class})
public class RootConfig {
	
	//配置事务管理
	@Bean
	public DataSourceTransactionManager transactionManager(DruidDataSource dataSource){
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource);
		return transactionManager;
	}
	
	//Spring与Mybatis整合 PS:失效
//	@Bean
//	public SqlSessionFactory sqlSessionFactory(DruidDataSource dataSource) throws Exception{
//		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//		sqlSessionFactoryBean.setDataSource(dataSource);
//		InputStream in = RootConfig.class.getClassLoader().getResourceAsStream("mapper-name.properties");
//		Properties properties = new Properties();
//		properties.load(in);
//		String mapperNames = properties.getProperty("mapper.names");
//		String[] mapperNameArr = mapperNames.split(",");
//		InputStreamResource[] mapperLocations = new InputStreamResource[mapperNameArr.length];
//		InputStream ins;
//		for(int i = 0; i < mapperNameArr.length; i++){
//			ins = RootConfig.class.getClassLoader().getResourceAsStream("mybatis-mapper/"+mapperNameArr[i]+".xml");
//			mapperLocations[i] = new InputStreamResource(ins);
//		}
//		sqlSessionFactoryBean.setMapperLocations(mapperLocations);	
//		InputStream in1 = RootConfig.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
//		InputStreamResource configLocation = new InputStreamResource(in1);
//		sqlSessionFactoryBean.setConfigLocation(configLocation);
//		return sqlSessionFactoryBean.getObject();
//	}
	
	//配置Mybatis模板
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
		return new SqlSessionTemplate(sqlSessionFactory);	
	}
	
}
