package com.zzz.spring_boot_thymeleaf.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

@Entity
//@NamedQuery(name="Person.ffindByName",query="select * from person p where p.name=?")
public class Person {

	@Id
	@GeneratedValue//hibernate会自动生成一个名为HIBERNATE_SEQUENCE序列。
	private Long id;
	private String name;
	@Min(value=5,message="不能小于5岁吧")
	private Integer age;
	private String address;
	
	public Person() {
		super();
	}

	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
