package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVo;

@Repository
public class BlogDao {

	// 기본설정-------------------------------------------------------------------

	@Autowired
	private SqlSession sqlSession;
	
	// 메인화면-------------------------------------------------------------------

	//아이디 입력시 해당 사용자의 개인 블로그로 이동, 정보 가져오기
	public BlogVo getBlogInfo(String id) {
		System.out.println("BlogDao : getBlogInfo");
		System.out.println("다오 : " + id);
		return sqlSession.selectOne("blog.getBlogInfo", id);
	}














}
