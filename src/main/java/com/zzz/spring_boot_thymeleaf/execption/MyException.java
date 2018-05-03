package com.zzz.spring_boot_thymeleaf.execption;

import com.zzz.spring_boot_thymeleaf.enums.ResultEnum;

/**
 * @author zyl
 * @date 2018年5月3日
 * @desc 自定义异常，包含code和message
 */
public class MyException extends Exception{
	private static final long serialVersionUID = 1L;
	private Integer code;
	
	public MyException(ResultEnum re) {
		super(re.getMsg());
		this.code = re.getCode();
	}
	public MyException(Integer code,String msg) {
		super(msg);
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
}
