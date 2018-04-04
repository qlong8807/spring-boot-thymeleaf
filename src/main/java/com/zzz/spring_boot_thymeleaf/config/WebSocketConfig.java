package com.zzz.spring_boot_thymeleaf.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * @author zyl
 * @date 2018年2月28日
 * @desc 广播式websocket
 * 通过@EnableWebSocketMessageBroker注解开启使用STOMP协议来传输基于代理（message broker）的消息，这时控制器支持使用@MessageMapping，就像使用@RequestMapping一样。
 * 
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer{

	@Override
	public void registerStompEndpoints(StompEndpointRegistry arg0) {//注册STOMP协议的节点（endpoint），并映射指定的URL。
		arg0.addEndpoint("/endpointTest").withSockJS();//注册一个STOMP的endpoint，并指定使用SockJS协议。
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {//配置消息代理（Message Broker）
		registry.enableSimpleBroker("/topic");//广播式应配置一个/topic消息代理。
	}
	

}
