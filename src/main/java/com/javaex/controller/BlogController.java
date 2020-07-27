package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.service.BlogService;
import com.javaex.vo.BlogVo;

@Controller
public class BlogController {

	// 기본설정-------------------------------------------------------------------
	@Autowired
	private BlogService blogService;

	// 메인화면-------------------------------------------------------------------

	// 아이디 입력시 해당 사용자의 개인 블로그로 이동, 정보 가져오기
	@RequestMapping("{id}")
	public String blogMain(@PathVariable("id") String id, Model model) {
		System.out.println("BlogController : blogMain");
		System.out.println("BlogController : " + id);

		model.addAttribute(id);

		BlogVo blogVo = blogService.getBlogInfo(id);
		model.addAttribute("blogVo", blogVo);

		return "/blog/blog-main";
	}

}
