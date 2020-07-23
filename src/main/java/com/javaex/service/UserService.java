package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {

	// 기본설정-------------------------------------------------------------------
	@Autowired
	private UserDao userDao;

	// 회원가입-------------------------------------------------------------------

	public int join(UserVo userVo) {
		System.out.println("UserService : join");

		return userDao.insert(userVo);
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

	//	로그인-------------------------------------------------------------------
	
	public UserVo login(UserVo userVo) {
		System.out.println("UserService : login");
		
		return userDao.selectUser(userVo);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
