package com.zzz.spring_boot_thymeleaf.controller;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zzz.spring_boot_thymeleaf.entity.Person;
import com.zzz.spring_boot_thymeleaf.entity.Result;
import com.zzz.spring_boot_thymeleaf.enums.ResultEnum;
import com.zzz.spring_boot_thymeleaf.execption.MyException;
import com.zzz.spring_boot_thymeleaf.util.ResultUtil;

@RestController
public class TestController {

	@GetMapping("test1")
	public Result test1() throws Exception {
		return ResultUtil.success(new Person("hello", 22));
	}
	@GetMapping("/test/{name}/{age}")
	public Result test(@PathVariable("age")Integer age,@PathVariable("name")String name) throws Exception {
		if(age <= 10) {
			throw new MyException(ResultEnum.TOO_YOUNG);
		}else if(age > 10 && age <= 20) {
			throw new MyException(ResultEnum.YOUNG);
		}
		return ResultUtil.success(new Person(name, age));
	}
	@PostMapping("/pers")
	public Result test(@Valid Person person,BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()) {
			System.err.println(bindingResult.getFieldError().getDefaultMessage());
			throw new MyException(100,bindingResult.getFieldError().getDefaultMessage());
		}
		return ResultUtil.success(person);
	}
}
