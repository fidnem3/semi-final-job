package com.javalab.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javalab.board.service.MemberService;
import com.javalab.board.vo.MemberVo;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/member")
@Slf4j
public class MemberController {

	@Autowired
	private MemberService memberService;

	@GetMapping("/create")
	public String createMember(Model model) {
		model.addAttribute("memberVo", new MemberVo());
		return "member/memberCreate";
	}

	@PostMapping("create")
	public String createMember(@ModelAttribute MemberVo memberVo) {
		log.info("createMember 메소드 : " + memberVo);
		memberService.createMember(memberVo);
		return "redirect:/member/list";
	}
	
	@GetMapping("/{memberId}")
	public String getMember(@PathVariable("memberId") String memberId, Model model) {
		MemberVo memberVo = memberService.getMember(memberId);
		model.addAttribute("memberVo", memberVo);
		return "member/memberDetail";
	}

}
