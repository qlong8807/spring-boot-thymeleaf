package com.zzz.spring_boot_thymeleaf.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.zzz.spring_boot_thymeleaf.entity.RequestMessage;
import com.zzz.spring_boot_thymeleaf.entity.ResponseMessage;

@Controller
public class WebSocketController {
	
	private Logger logger = LoggerFactory.getLogger(WebSocketController.class);
	
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;//通过SimpMessagingTemplate向浏览器发送消息。

	/**
	 * 广播式websocket
	 * @param message
	 * @return
	 */
	@MessageMapping("/welcome")//当浏览器向服务端发送请求时，通过@MessageMapping映射到/welcome，类似于@RequestMapping
	@SendTo("/topic/getResponse")//当服务端有消息时，会对订阅了@SendTo中的路径的浏览器发送消息
	public ResponseMessage say(RequestMessage message) {
		logger.debug("收到的消息是："+message.toString());
		logger.error("收到的消息是："+message.toString());
		return new ResponseMessage("welcome,"+message.getMsg()+"!!!");
	}
	
	@MessageMapping("/chat")
	public void handleChat(Principal principal,String msg) {//在SpringMVC中，可以直接在参数中获得principal，principal中包含当前用户的信息。
		if("zhangsan".equals(principal.getName())) {
			//向用户发送消息，第一个参数是接收消息的用户，第二个是浏览器订阅的地址，第三个是消息本身。
			simpMessagingTemplate.convertAndSendToUser("lisi", "/queue/notifications", principal.getName()+"-send:"+msg);
		}else {
			simpMessagingTemplate.convertAndSendToUser("zhangsan", "/queue/notifications", principal.getName()+"-send:"+msg);
		}
	}
	
}
