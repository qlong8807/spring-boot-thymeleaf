package com.zzz.spring_boot_thymeleaf.entity;

/**
 * @author zyl
 * @date 2018年2月28日
 * @desc websocket中服务器给浏览器发送的消息类
 */
public class ResponseMessage {

	private String msg_response;
	

	public ResponseMessage(String msg_response) {
		super();
		this.msg_response = msg_response;
	}

	public String getMsg_response() {
		return msg_response;
	}

	public void setMsg_response(String msg_response) {
		this.msg_response = msg_response;
	}

	
}
