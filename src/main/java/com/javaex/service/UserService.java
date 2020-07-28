package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogAdminDao;
import com.javaex.dao.CategoryDao;
import com.javaex.dao.UserDao;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.UserVo;

@Service
public class UserService {

	// 기본설정-------------------------------------------------------------------
	@Autowired
	private UserDao userDao;

	@Autowired
	private BlogAdminDao blogAdminDao;

	@Autowired
	private CategoryDao categoryDao;

	// 회원가입-------------------------------------------------------------------

	public int join(UserVo userVo) {
		System.out.println("UserService : join");

		int user = userDao.insert(userVo);

		BlogVo blogVo = new BlogVo();
		blogVo.setId(userVo.getId());
		blogVo.setBlogTitle(userVo.getUserName() + "의 블로그입니다.");
		blogVo.setLogoFile("default");

		int blog = blogAdminDao.blogInsert(blogVo);

		CategoryVo categoryVo = new CategoryVo();
		categoryVo.setId(blogVo.getId());
		categoryVo.setCateName("미분류");
		categoryVo.setDescription("기본으로 만들어지는 카테고리입니다.");

		int category = categoryDao.categoryInsert(categoryVo);

		if (user == 1 && blog == 1 && category == 1)
			return 1;
		else
			return 0;
	}

	// id중복체크(ajax)-----------------------------------------------------------

	public boolean checkId(String id) {
		System.out.println("UserService : checkId");

		UserVo userVo = userDao.selectUser(id);
		boolean result = true;

		if (userVo == null) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	// 로그인-------------------------------------------------------------------

	public UserVo login(UserVo userVo) {
		System.out.println("UserService : login");

		return userDao.selectUser(userVo);
	}

	// 로그인한 사용자 정보 가져오기-----------------------------------------------------

	public UserVo getUser(int no) {
		System.out.println("로그인한 유저 정보 가져오기 : UserService-getUser");

		return userDao.getUser(no);
	}

}
