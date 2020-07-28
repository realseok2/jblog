package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.CategoryVo;

@Repository
public class CategoryDao {

	// 기본설정----------------------------------------------------------------------
	
	@Autowired
	private SqlSession sqlSession;
	
	// 카테고리 리스트--------------------------------------------------------------------	
	
	public List<CategoryVo> cateList(String id) {
		System.out.println("CategoryDao : cateList");
		
		List<CategoryVo> cateList = sqlSession.selectList("category.cateList", id);
		return cateList;
	}
	
	
	
	
	// 카테고리 추가--------------------------------------------------------------------	
	
	public int categoryInsert(CategoryVo categoryVo) {
		System.out.println("CategoryDao : categoryInsert");
		return 1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
