package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {

	// 기본설정-------------------------------------------------------------------

	@Autowired
	private SqlSession sqlSession;

	// 회원가입-------------------------------------------------------------------

	public int insert(UserVo userVo) {
		System.out.println("UserDao : insert");

		System.out.println("userDao-----" + userVo.toString());
		return sqlSession.insert("user.insert", userVo);
	}

	// id중복체크(ajax)-----------------------------------------------------------

	public UserVo selectUser(String id) {
		System.out.println("UserDao : selectUser");

		UserVo userVo = sqlSession.selectOne("user.selectById", id);
		return userVo;
	}
	
	// 로그인--------------------------------------------------------------------	
	
	public UserVo selectUser(UserVo userVo) {
		System.out.println("UserDao : selectUser");
		System.out.println("UserDao ------" + userVo.toString());
		
		return sqlSession.selectOne("user.selectUser", userVo);
	}
	
	// 로그인한 사용자 정보 가져오기-----------------------------------------------------	
	
	public UserVo getUser(int no) {
		System.out.println("로그인한 사용자 정보 가져오기 : UserDao-getUser");
		
		return sqlSession.selectOne("user.getUser", no);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
