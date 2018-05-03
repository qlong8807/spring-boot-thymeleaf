package com.zzz.spring_boot_thymeleaf.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzz.spring_boot_thymeleaf.entity.Result;
import com.zzz.spring_boot_thymeleaf.execption.MyException;
import com.zzz.spring_boot_thymeleaf.util.ResultUtil;

/**
 * @author zyl
 * @date 2018年5月3日
 * @desc controller中的方法可以直接throw Exception.抛出的异常在这里会转换为Result对象。
 */
@ControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	public Result handler(Exception e) {
		if(e instanceof MyException) {
			MyException me = (MyException) e;
			return ResultUtil.fail(me.getCode(), me.getMessage());
		}else {
			return ResultUtil.fail(500, "未知错误："+e.getMessage());
		}
	}
}
