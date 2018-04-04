package com.zzz.spring_boot_thymeleaf.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author zyl
 * @date 2018年2月27日
 * @desc 添加自己的web配置
 */
@Configuration
public class MyConfig extends WebMvcConfigurerAdapter{

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addViewControllers(org.springframework.web.servlet.config.annotation.ViewControllerRegistry)
	 * 这里重写的addViewControllers方法并不会覆盖WebMvnAutoConfiguration中的addViewControllers方法（在此方法中，SpringBoot把/映射到index.html页面）。
	 * 这也就意味着自己的配置和SpringBoot的自动配置同时生效。这是推荐的方式。
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/index2").setViewName("/index2");
		registry.addViewController("/ws").setViewName("/websocket/ws");
		registry.addViewController("/login").setViewName("/login");
		registry.addViewController("/chat").setViewName("/chat/chat");
	}
	
	/**
	 * 配置Servlet。等同于ServletConfig的配置或者配置文件的配置。
	 * @return
	 */
//	@Bean
//	public EmbeddedServletContainerFactory servletContainerFactory() {
//		TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
//		factory.setPort(8888);
//		factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/404.html"));
//		factory.setSessionTimeout(10, TimeUnit.MINUTES);
//		return factory;
//	}

}
