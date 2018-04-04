package com.zzz.spring_boot_thymeleaf.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.zzz.spring_boot_thymeleaf.entity.Person;

/**
 * @author zyl
 * @date 2018年3月1日
 * @desc 这里使用了findBy，也可以用find,read,readBy,query,queryBy,get,getBy代替。
 */
public interface PersonRepository extends JpaRepository<Person, Long>{

	/**
	 * 通过名称相等查询
	 * 相当于 select * from person p where p.name = ?
	 */
	List<Person> findByName(String name);
	/**
	 * 这里使用的是Person类中定义的NamedQuery查询语句，而不是根据方法名查询。
	 */
//	List<Person> ffindByName(String name);
	/**
	 * 这里使用的是@Query查询。
	 */
//	@Query("select * from person p where p.name = ?")
//	List<Person> fffindByName(String name);
//	/**
//	 * 这里使用的是@Query的命名参数查询。
//	 */
//	@Query("select * from person p where p.name = :name2")
//	List<Person> ffffindByName(@Param("name2")String name3);
	/**
	 * 通过名称模糊查询
	 * 相当于 select * from person p where p.name like ?
	 */
	List<Person> findByNameLike(String name);
	/**
	 * 通过名称模糊查询
	 * 相当于 select * from person p where p.name = ? and p.address = ?
	 */
	List<Person> findByNameAndAddress(String name,String address);
	
	/**
	 * 获得符合查询条件的前10条
	 */
	List<Person> findFirst10ByName(String name);
	/**
	 * 获得符合查询条件的前30条
	 */
	List<Person> findTop30ByName(String name);
	/**
	 * 排序查询
	 * 使用方式：List<Person> people = personRepository.findByName("x",new Sort(Direction.ASC,"age"));
	 */
	List<Person> findByName(String name,Sort sort);
	/**
	 * 分页查询
	 * 使用方式：Page<Person> people = personRepository.findByName("x",new PageRequest(0,10));
	 */
	Page<Person> findByName(String name,Pageable pageable);
	
	
	
	/**
	 * @param name
	 * @return 影响的行数
	 */
	@Modifying
	@Transactional
	@Query("update Person p set p.age=? where p.name=?")
	int setAgeByName(String name);
	
	
}
