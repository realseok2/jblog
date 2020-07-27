package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVo;

@Repository
public class BlogAdminDao {

	// 기본설정----------------------------------------------------------------------
	@Autowired
	private SqlSession sqlSession;
	
	// 블로그관리 기본설정---------------------------------------------------------------
	// 기본설정 첫 화면
	public BlogVo getBlogInfo(String id) {
		System.out.println("BlogAdminDao : getBlogInfo");
		
		return sqlSession.selectOne("blog.getBlogInfo", id);
	}
	
	// 블로그 기본설정 셋팅
	public int blogInsert(BlogVo blogVo) {
		System.out.println("BlogAdminDao : blogInsert");
		
		return sqlSession.insert("blog.blogInsert", blogVo);
	}
	
	// 기본설정 수정
	public int blogModify(BlogVo blogVo) {
		System.out.println("BlogAdminDao : blogModify");
		
		return sqlSession.update("blog.update", blogVo);
	}
	
	// 기본설정 이미지 디폴트값 수정
	public BlogVo blogInfo(String id) {
		System.out.println("BlogAdminDao : blogInfo");
		
		return sqlSession.selectOne("blog.blogInfo", id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
