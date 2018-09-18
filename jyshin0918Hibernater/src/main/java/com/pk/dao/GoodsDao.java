package com.pk.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pk.domain.Goods;


//bean을 자동으로 만들어주는 어노테이션 
@Repository
public class GoodsDao {
//동일한 자료형의 bean이 있는 경우 자동으로 주입받는 설정 
	@Autowired
	//하이버네이트를 사용하기 위한 인스턴스 변수 
	private SessionFactory sessionFactory;
	
	//메소드에서 예외가 발생하면 rollback되고, 예외가 발생하지 않으면 commit 되도록 해주는 어노테이션 
	@Transactional
	//데이터를 삽입하는 메소드 
	public void insertGoods(Goods goods) {
		sessionFactory.getCurrentSession().save(goods);
	}
	
	@Transactional
	//데이터를 수정하는 메소드 
	public void updateGoods(Goods goods) {
		sessionFactory.getCurrentSession().update(goods);
	}
	
	@Transactional
	//데이터를 수정하는 메소드 
	public void deleteGoods(Goods goods) {
		sessionFactory.getCurrentSession().delete(goods);
	}
	
	@Transactional
	//전체 데이터를 조회하는 메소드 
	public List<Goods> list(){
		return (List<Goods>)sessionFactory.getCurrentSession().createCriteria(Goods.class).list();
	}
	
	@Transactional
	//code로 데이터를 조회하는 메소드 
	public Goods get(int code){
		return (Goods)sessionFactory.getCurrentSession().get(Goods.class, code);
	}
	
}
