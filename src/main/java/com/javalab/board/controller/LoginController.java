package com.javalab.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.javalab.board.service.LoginService;
import com.javalab.board.vo.JobSeekerVo;

import lombok.extern.slf4j.Slf4j;

/**
 * 로그인 컨트롤러
 *
 */
@Controller
@Slf4j
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 로그인 폼 제공
     */
    @GetMapping("/login")
    public String login(Model model, JobSeekerVo jobSeekerVo) {
		/* model.addAttribute("jobSeekerVo", jobSeekerVo); */
        return "login/login"; // login/login.jsp로 이동 forward방식
    }
    /**
     * 로그인 처리
     * @param jobSeekerVo
     * @param session : 로그인 사용자의 정보를 세션보관하기 위해서 필요
     * @param redirectAttributes : sendRedirect로 옮겨간 페이지에서 사용가능, 일회성
     */
    @PostMapping("/login")
    public String login(@ModelAttribute("jobSeekerVo") JobSeekerVo jobSeekerVo, 
                   HttpSession session, 
                   RedirectAttributes redirectAttributes, 
                   Model model) {
       // 사용자 조회
        JobSeekerVo LoginJobSeekerVo = loginService.login(jobSeekerVo);
        // 조회 결과가 있으면 세션에 저장
        if (LoginJobSeekerVo != null) {
            session.setAttribute("jobSeekerVo", LoginJobSeekerVo);
            log.info("세션에 사용자 저장 완료 ");
            // 세션에 저장한 사용자 정보 조회
            //JobSeekerVo jobSeeker = (JobSeekerVo) session.getAttribute("jobSeekerVo");
            return "redirect:index"; // index 페이지로 리다이렉트
            
        } else {
            //model.addAttribute("error", "아이디와 비밀번호를 확인하세요");
           redirectAttributes.addFlashAttribute("error", "아이디와 비밀번호를 확인하세요");
           // 다음 jsp화면에서 jobSeekerVo 이름으로 죄회가능. 단 일회성으로 새로고침하면 사라짐
           redirectAttributes.addFlashAttribute("jobSeekerVo", jobSeekerVo);
            return "redirect:/login"; // /login 요청(로그인 폼)
        }
    }
    
    
    /**
     * 로그아웃 처리
     * @param session
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        // 세션에서 jobSeekerVo라는 이름으로 저장된 객체 삭제
        session.removeAttribute("jobSeekerVo");
        // 세션 전체를 무효화
        session.invalidate();
        // 로그인 페이지로 리다이렉트
        return "redirect:/login";
    }
}
