package com.pk.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import com.pk.mybatis.domain.RegisterVO;

public interface RegisterInterface {
	@Select("select * from register")
	public List<RegisterVO> listuser();
	
	@Select("select * from register where id=#{id}")
	public RegisterVO selectoneuser(String id);
	
	@Insert("insert into register values(#{id}, #{pw}, #{name}, #{phone})")
	public List<RegisterVO> insertuser();
	
	@Delete("delete from register where id=#{id}")
	public List<RegisterVO> deleteuser(String id);
}
