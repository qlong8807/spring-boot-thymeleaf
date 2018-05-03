package com.zzz.spring_boot_thymeleaf.enums;

public enum ResultEnum {
	UNKNOW_ERROR(500,"未知错误"),
	SUCCESS(0,"成功"),
	/** 定义各种错误*/
	FAIL(1,"失败"),
	TOO_YOUNG(100,"太年轻"),
	YOUNG(101,"年轻"),
	;
	private Integer code;
	private String msg;
	private ResultEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	public Integer getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
	
}
