package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;
import com.javaex.vo.BlogVo;

@Service
public class BlogService {

	// 기본설정-------------------------------------------------------------------
	@Autowired
	private BlogDao blogDao;

	// 메인화면-------------------------------------------------------------------

	// 아이디 입력시 해당 사용자의 개인 블로그로 이동, 정보 가져오기
	public BlogVo getBlogInfo(String id) {
		System.out.println("BlogService : getBlogInfo");

		return blogDao.getBlogInfo(id);
	}

}
