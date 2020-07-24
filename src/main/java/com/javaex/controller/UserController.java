package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {

	// 기본설정-------------------------------------------------------------------
	@Autowired
	private UserService userService;

	// 회원가입-------------------------------------------------------------------

	// 회원가입폼
	@RequestMapping("/joinForm")
	public String joinForm() {
		System.out.println("UserController : joinForm");

		return "/user/joinForm";
	}

	// id중복체크(ajax)
	@ResponseBody
	@RequestMapping("/idcheck")
	public boolean idcheck(@RequestParam("txtId") String id) {
		System.out.println("UserController : idcheck");
		System.out.println(id);

		boolean result = userService.checkId(id);
		return result;
	}

	// 회원가입
	@RequestMapping("/join")
	public String join(@ModelAttribute UserVo userVo) {
		System.out.println("UserController : join");
		System.out.println("유저컨트롤러 전------" + userVo.toString());		
		userService.join(userVo);
		System.out.println("유저컨트롤러 후------" + userVo.toString());
		return "redirect:/user/joinSuccess";
	}

	// 회원가입성공
	@RequestMapping("/joinSuccess")
	public String joinSuccess() {
		System.out.println("UserController : joinSuccess");
		return "/user/joinSuccess";
	}
	
	
	// 로그인-------------------------------------------------------------------

	// 로그인폼
	@RequestMapping("/loginForm")
	public String loginForm() {
		System.out.println("UserController : loginForm");

		return "/user/loginForm";
	}
	
	//	로그인
	@RequestMapping("/login")
	public String login(@ModelAttribute UserVo userVo, HttpSession session) {
		System.out.println("UserController : login");
		
		UserVo authUser = userService.login(userVo);
		
		//로그인 성공시
		if(authUser != null) {
			System.out.println("로그인 성공");
			session.setAttribute("authUser", authUser);
			System.out.println("로그인성공 : " + authUser.toString());
			return "redirect:/";
			
		//로그인 실패시
		} else {
			System.out.println("로그인 실패");
			return "redirect:/user/loginForm?result=fail";
		}
	}
	
	//	로그인한 사용자 정보 가져오기
	@RequestMapping("/getUser")
	public String getUser(Model model, HttpSession session) {
		System.out.println("UserController : getUser");
		
		int no = ((UserVo)session.getAttribute("authUser")).getUserNo();
		
		UserVo authUser = userService.getUser(no);
		model.addAttribute("authUser", authUser);
		return "redirect:/";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	// 로그아웃-------------------------------------------------------------------
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		System.out.println("UserController : logout");
		
		session.removeAttribute("authUser");
		session.invalidate();
		
		return "redirect:/";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



}
