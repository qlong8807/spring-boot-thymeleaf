package com.zzz.spring_boot_thymeleaf.entity;

/**
 * @author zyl
 * @date 2018年2月28日
 * @desc websocket中浏览器给服务器发送的消息类
 */
public class RequestMessage {

	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "RequestMessage [msg=" + msg + "]";
	}
	
	
	
}
