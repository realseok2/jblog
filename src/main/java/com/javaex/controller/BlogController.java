package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog")
public class BlogController {

	// 기본설정-------------------------------------------------------------------
//	@Autowired
//	private BlogService blogService;

	// 메인화면-------------------------------------------------------------------

	//아이디 입력시 해당 사용자의 개인 블로그로 이동
	@RequestMapping("/{id}")
	public String blogMain() {
		System.out.println("BlogController : blogMain");
		
		return "/blog/blog-main";
	}
	
	
	
	// 기본설정-------------------------------------------------------------------
	
	
	
	
	// 기본설정-------------------------------------------------------------------
	
	
	
	
	// 기본설정-------------------------------------------------------------------
	
	
	// 기본설정-------------------------------------------------------------------























}
