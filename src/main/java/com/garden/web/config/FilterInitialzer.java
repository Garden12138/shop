package com.garden.web.config;

import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;

import com.garden.web.filter.ExtraFilter;



/**
 * Filter初始化类
 * @author Garden
 * 2018年4月2日
 */
public class FilterInitialzer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		Dynamic filter = servletContext.addFilter("extraFilter", ExtraFilter.class);
		//filter.addMappingForServletNames(null, false, "extraServlet");过滤自定义Servlet
		filter.addMappingForUrlPatterns(null, false, "/extra/*");
	}

}
