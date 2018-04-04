package com.zzz.spring_boot_thymeleaf.config;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.http.HttpStatus;

/**
 * @author zyl
 * @date 2018年2月28日
 * @desc 通过Java配置Servlet容器。如果要把这个类放在SpringBoot启动类或者配置文件类中，则需要把该类改为static类。
 * 启用注解后，即可生效
 */
//@Component
public class ServletConfig implements EmbeddedServletContainerCustomizer{

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setPort(8080);
		container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/404.html"));
		container.setSessionTimeout(30, TimeUnit.MINUTES);
	}

}
