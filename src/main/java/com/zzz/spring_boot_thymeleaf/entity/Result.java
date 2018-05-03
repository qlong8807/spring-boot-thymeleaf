package com.zzz.spring_boot_thymeleaf.entity;

public class Result<T> {
	
	private Integer code;
	private String msg;
	private T obj;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getObj() {
		return obj;
	}
	public void setObj(T obj) {
		this.obj = obj;
	}
	@Override
	public String toString() {
		return "Result [code=" + code + ", msg=" + msg + ", obj=" + obj + "]";
	}
	

}
