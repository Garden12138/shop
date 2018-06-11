package com.garden.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
/**
 * 控制器扫描配置类
 * @author Garden
 * 2018年3月25日
 */
@Configuration
@ComponentScan(basePackages={"com.garden.web.controller"})
public class ControllerConfig {

}
