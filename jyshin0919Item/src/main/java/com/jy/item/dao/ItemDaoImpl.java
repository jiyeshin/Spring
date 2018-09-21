package com.jy.item.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jy.item.domain.Item;
@Repository
public class ItemDaoImpl implements ItemDao {
	//MyBatis 실행 객체 주입 
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<Item> listItem() {
		
		return sqlSession.selectList("item.selectitem");
	}

	@Override
	public Item getItem(String itemname) {
		return sqlSession.selectOne("item.selectoneitem", itemname);
	}

	
}
