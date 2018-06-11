package com.garden.web.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.garden.web.filter.ExtraFilter;
/**
 * Web应用初始类
 * @author Garden
 * 2018年3月25日
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	/*加载ContextLoaderListener 数据层组件（bean，数据源等）*/
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] {RootConfig.class};
	}

	/*加载DispatcherServlet web组件（bean，映射处理器，控制器，视图解析器）*/
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] {WebConfig.class};
	}

	/*将DispatcherServlet映射到'/'*/
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/extra/*","/"};
	}
	
//	/*定义过滤器并将过滤器映射至DispatcherServlet*/
//	@Override
//	protected Filter[] getServletFilters(){
//		return new Filter[]{new ExtraFilter()};
//		
//	}
	
	/*基于Servlet3.0的multipart请求解析器具体配置*/
	@Override
	protected void customizeRegistration(Dynamic registration){
		registration.setMultipartConfig(
				new MultipartConfigElement("",2097152,4194304,0));
		/*参数：存放文件临时路径，上传文件的文件大小，请求的最大容量，最大内存大小*/
	}
	
}
