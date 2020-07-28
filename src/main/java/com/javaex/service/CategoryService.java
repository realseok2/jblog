package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.CategoryDao;
import com.javaex.vo.CategoryVo;

@Service
public class CategoryService {

	// 기본설정----------------------------------------------------------------------
	
	@Autowired
	private CategoryDao categoryDao;
	
	// 기본설정----------------------------------------------------------------------
	
	public List<CategoryVo> cateList(String id) {
		System.out.println("CategoryService : cateList");
		
		List<CategoryVo> cateList = categoryDao.cateList(id);
		return cateList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
