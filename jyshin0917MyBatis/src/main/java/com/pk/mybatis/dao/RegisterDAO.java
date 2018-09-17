package com.pk.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pk.mybatis.domain.RegisterVO;

//자동으로 bean을 생성해주는 어노테이션 
@Repository
public class RegisterDAO {
	// 동일한 자료형의 bean이 있으면 자동으로 주입받는 어노테이션
	//@Autowired
	private SqlSession sqlSession;

	// Register 테이블의 전체 데이터를 가져오는 메소드
	public List<RegisterVO> userlist() {
		return sqlSession.selectList("regi.userlist");
	}

	// Register 테이블에서 id로 하나의 데이터를 가져오는 메소드
	public RegisterVO selectuser(String id) {
		// 하나를 찾아오는 메소드 호출
		// 없으면 null 리턴
		// 2개 이상이면 예외 발생시킴
		return sqlSession.selectOne("regi.selectuser", id);
	}

	// Register 테이블에 데이터를 삽입하는 메소드
	public int insertuser(RegisterVO vo) {
		return sqlSession.insert("regi.insertuser", vo);
	}
	
	//procedure를 이용해서 테이블에 데이터 삽입하는 메소드 
	public int insertprocedure(RegisterVO vo) {
		return sqlSession.insert("regi.insertproc", vo);
	}

}
