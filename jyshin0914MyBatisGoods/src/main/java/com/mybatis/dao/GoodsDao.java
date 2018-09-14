package com.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mybatis.domain.Goods;

//객체를 자동으로 생성해주는 어노테이션 
@Repository
public class GoodsDao {
//동일한 자료형의 bean이 있으면 자동으로 대입해주는 어노테이션 
	@Autowired
	private SqlSession sqlSession;

//테이블 전체의 데이터를 가져오는 메소드 select 
	public List<Goods> list() {
		return sqlSession.selectList("goods.list");
	}
	
	//테이블에 데이터를 삽입하는 메소드 insert 
	public int insertGoods(Goods goods) {
		return sqlSession.insert("goods.insertgood", goods);
	}

}
