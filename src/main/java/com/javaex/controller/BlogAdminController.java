package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.BlogAdminService;
import com.javaex.vo.BlogVo;

@Controller
@RequestMapping("/{id}/admin")
public class BlogAdminController {

	// 기본설정----------------------------------------------------------------------
	@Autowired
	private BlogAdminService blogAdminService;

	// 블로그관리 기본설정---------------------------------------------------------------
	// 기본설정 화면
	@RequestMapping("/basic")
	public String basic(@PathVariable("id") String id, Model model) {
		System.out.println("BlogAdminController : basic");

		BlogVo blogVo = blogAdminService.getBlogInfo(id);
		model.addAttribute("blogVo", blogVo);

		return "/blog/admin/blog-admin-basic";
	}

	// 기본설정 수정
	@RequestMapping("/modify")
	public String upload(@PathVariable("id") String id, @RequestParam("file") MultipartFile file,
			@ModelAttribute BlogVo blogVo) {
		System.out.println("BlogAdminController : modify");
		System.out.println(file.getOriginalFilename());

		blogAdminService.blogModify(id, blogVo, file);

		return "redirect:/{id}";
	}

	// 블로그관리 카테고리---------------------------------------------------------------
	@RequestMapping("/category")
	public String category() {
		System.out.println("BlogAdminController : category");
		return "/blog/admin/blog-admin-cate";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	// 블로그관리 글작성----------------------------------------------------------------
	// 글작성 폼
	@RequestMapping("/writeForm")
	public String writeForm() {
		System.out.println("BlogAdminController : writeForm");
		return "/blog/admin/blog-admin-write";
	}

	// 글작성
	@RequestMapping("/write")
	public String write() {
		System.out.println("BlogAdminController : write");
		return "/blog/admin/blog-admin-write";
	}

}
