package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.FileUploadService;

@Controller
public class FileUploadController {

	// 기본설정-----------------------------------------------------------
	@Autowired
	private FileUploadService fileUploadService;

	// 업로드 폼-----------------------------------------------------------
	@RequestMapping("/admin/basic")
	public String basic() {
		System.out.println("FileUploadController : basic");

		return "/blog/admin/blog-admin-basic";
	}

	// 업로드-----------------------------------------------------------
	@RequestMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file, Model model) {
		System.out.println("FileUploadController : upload");
		System.out.println(file.getOriginalFilename());

		String saveName = fileUploadService.restore(file);
		model.addAttribute("saveName", saveName);

		return "redirect:/{id}";
	}

}
