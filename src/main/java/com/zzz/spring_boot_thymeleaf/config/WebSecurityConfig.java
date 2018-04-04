package com.zzz.spring_boot_thymeleaf.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author zyl
 * @date 2018年3月1日
 * @desc 点对点websocket的安全控制。设置login登录成功跳转到chat页面。
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/", "/login").permitAll()//1.设置Security对/和/login请求不拦截
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/login")//2.设置Security的登录页面访问路径为/login
			.defaultSuccessUrl("/chat")//3.登录成功后转向/chat路径
			.permitAll()
			.and()
			.logout()
			.permitAll();
	}

	/* 
	 * 在内存中配置两个用户，角色是USER
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("zhangsan").password("1").roles("USER")
			.and()
			.withUser("lisi").password("2").roles("USER");
	}

	//不拦截/resources/static路径下的静态资源
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/static/**");
	}
	
}
