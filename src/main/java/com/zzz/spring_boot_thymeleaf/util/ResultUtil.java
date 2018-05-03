package com.zzz.spring_boot_thymeleaf.util;

import com.zzz.spring_boot_thymeleaf.entity.Result;

public class ResultUtil {

	public static Result success(Object obj) {
		Result result = new Result();
		result.setCode(0);
		result.setMsg("");
		result.setObj(obj);
		return result;
	}
	
	public static Result fail(Integer code,String msg) {
		Result result = new Result();
		result.setCode(code);
		result.setMsg(msg);
		result.setObj(null);
		return result;
	}
}
