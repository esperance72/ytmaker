package com.supplyDepot.ytmaker.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.supplyDepot.ytmaker.model.dto.MemberVO;
import com.supplyDepot.ytmaker.service.MemberService;

@Controller						// 현재 클래스를 스프링에서 관리하는 컨트롤러 bean으로 생성
@RequestMapping("/member/*")	// 모든 맵핑은 /member/를 상속
public class MemberController {
	//private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	MemberService memberService;
	
	// 1.로그인 화면
	@RequestMapping("login.do")
	public String login() {
		return "member/login";	// views/member/login.jsp로 포워드
	}
	// 2.로그인 처리	
	@RequestMapping("loginCheck.do")
	public ModelAndView loginCheck(@ModelAttribute MemberVO vo, HttpSession session) {
		boolean result = memberService.loginCheck(vo, session);
		ModelAndView mav = new ModelAndView();
		if (result == true) {	// 로그인 성공
			mav.setViewName("home");
			mav.addObject("msg", "success");
		} else {				// 로그인 실패
			// login.jsp로 이동
			mav.setViewName("member/login");
			mav.addObject("msg","failure");
		}
		
		return mav;
	}
	
	// 3.로그아웃 처리
	@RequestMapping("logout.do")
	public ModelAndView logout(HttpSession session) {
		memberService.logout(session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/login");
		mav.addObject("msg","logout");
		
		return mav;
	}
}
