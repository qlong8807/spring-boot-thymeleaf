package com.zzz.spring_boot_thymeleaf.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author zyl
 * @date 2018年5月3日
 * @desc AOP拦截器
 */
@Aspect
@Component
public class LogAspect {
	
	private Logger logger = LoggerFactory.getLogger(LogAspect.class);

	/**
	 * 拦截controller包下的所有类的所有方法
	 */
	@Pointcut("execution(public * com.zzz.spring_boot_thymeleaf.controller.*.*(..))")
	private void log() {}
	
	@Before("log()")
	public void before(JoinPoint joinPoint) {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		//url
		logger.info("url={}",request.getRequestURL());
		//method
		logger.info("method={}",request.getMethod());
		//ip
		logger.info("ip={}",request.getRemoteAddr());
		String className = joinPoint.getSignature().getDeclaringTypeName();
		String classMethod = joinPoint.getSignature().getName();
		logger.info("class-method={}",className+"."+classMethod);
		Object[] args = joinPoint.getArgs();
		logger.info("args={}",args);
	}
	@After("log()")
	public void afger() {
		logger.info("method after");
	}
	/**
	 * 这里会打印controller方法的返回对象
	 * @param object
	 */
	@AfterReturning(returning="object",pointcut="log()")
	public void afterReturn(Object object) {
		logger.info("response==>{}",object.toString());
	}
}
