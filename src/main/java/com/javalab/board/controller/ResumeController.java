package com.javalab.board.controller;

import com.javalab.board.service.JobSeekerService;	
import com.javalab.board.service.ResumeService;
import com.javalab.board.vo.JobSeekerVo;
import com.javalab.board.vo.ResumeVo;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/resumes")
@Slf4j
public class ResumeController {

    @Autowired
    private ResumeService resumeService;
    
    @Autowired
    private JobSeekerService jobSeekerService;
    
    /**
	 * 게시물 목록 보기 메소드
	 */
    @GetMapping
    public String listResumes(Model model) {
        String jobseekerId = "java";
        JobSeekerVo jobSeekerVo = jobSeekerService.getJobSeeker(jobseekerId);
        List<ResumeVo> resumes = resumeService.getAllResumes();
        
        // Resumes를 resumeId 기준으로 정렬
        resumes.sort(Comparator.comparingInt(ResumeVo::getResumeId));

        model.addAttribute("jobSeekerVo", jobSeekerVo);
        model.addAttribute("resumes", resumes);
        return "resume/list"; //jsp 이름
    }

    @GetMapping("/new")
    public String newResumeForm(Model model) {
        // 세션에서 사용자 정보 조회 (예: 세션에 저장된 jobSeekerId를 사용)
        String jobseekerId = "java";
        
        // 개인 신상 정보 조회
        JobSeekerVo jobSeekerVo = jobSeekerService.getJobSeeker(jobseekerId);
        
        model.addAttribute("jobSeekerVo", jobSeekerVo);
        model.addAttribute("resume", new ResumeVo());
        return "resume/new";
    }

    // 기존 폼 제출 방식
    @PostMapping
    public String createResume(@ModelAttribute ResumeVo resume) {
        resumeService.createResume(resume);
        return "redirect:/resumes";
    }

	
	  // AJAX 방식
	  
	  @PostMapping("/write")
	  
	  @ResponseBody public ResponseEntity<?> createResumeAjax(@RequestBody ResumeVo
	  resume) { try { resumeService.createResume(resume); return
	  ResponseEntity.ok().body(Map.of("redirectUrl", "/resumes/", "msg",
	  "이력서가 성공적으로 저장되었습니다.")); } catch (Exception e) { return
	  ResponseEntity.badRequest().body(Map.of("msg", "이력서 저장 중 오류가 발생했습니다.")); } }
	 


	      @GetMapping("/{resumeId}")
    public String viewResume(@PathVariable int resumeId, Model model) {
	  String jobseekerId = "java";
	  JobSeekerVo jobSeekerVo = jobSeekerService.getJobSeeker(jobseekerId);
      model.addAttribute("jobSeekerVo", jobSeekerVo);
        ResumeVo resume = resumeService.getResumeById(resumeId);
        model.addAttribute("resume", resume);
        return "resume/view";
    }
	      
// 	  	수정은 됐다고 알림만뜨고 저장은 안되는것 업데이트
@GetMapping("/{resumeId}/edit")
    public String editResumeForm(@PathVariable int resumeId, Model model) {
        ResumeVo resume = resumeService.getResumeById(resumeId);
        
        model.addAttribute("resume", resume);
        return "resume/edit";
    }

 //	 		업데이트 한 후에 폼 보여주는 
    	@PostMapping("/{resumeId}/update")
    	public String updateResume(@PathVariable int resumeId, @ModelAttribute ResumeVo resume, HttpSession session) {
        String jobSeekerId = (String) session.getAttribute("jobSeekerId");
        if (jobSeekerId == null) {
            // Handle the case where jobSeekerId is not in session
            return "redirect:/login"; // or appropriate error handling
        }
        resume.setResumeId(resumeId);
        resume.setJobSeekerId(jobSeekerId);
        resumeService.updateResume(resume);
        return "redirect:/resumes"; // 업데이트 후 목록 페이지로 리디렉션
    }
    
	/*
	 * @GetMapping("/update") public String updateResume(@RequestParam("resumeId")
	 * int resumeId, HttpSession session, Model model) { // 세션에서 사용자 정보 조회
	 * JobSeekerVo jobSeekerVo = (JobSeekerVo) session.getAttribute("jobSeekerVo");
	 * if (jobSeekerVo == null) { return "redirect:/"; }
	 * 
	 * ResumeVo resumeVo = resumeService.getResumeById(resumeId);
	 * model.addAttribute("resumeVo", resumeVo); // 화면에 보여줄 이력서를 model에 저장 return
	 * "resume/resumeUpdate"; }
	 * 
	 * @PostMapping("/update") public String
	 * updateResume(@ModelAttribute("resumeVo") ResumeVo resumeVo, HttpSession
	 * session) { // 세션에서 사용자 정보 조회 JobSeekerVo jobSeekerVo = (JobSeekerVo)
	 * session.getAttribute("jobSeekerVo"); if (jobSeekerVo == null) { return
	 * "redirect:/"; }
	 * 
	 * // 세션에서 조회한 사용자를 작성자로 설정
	 * resumeVo.setJobSeekerId(jobSeekerVo.getJobSeekerId());
	 * 
	 * resumeService.updateResume(resumeVo); return "redirect:/resume/list"; // 목록
	 * 요청(listResume() 호출) }
	 */


	      
	      
	      
	      
	      
	      
	      
	      
	      
    @PostMapping("/{resumeId}/delete")
    public String deleteResume(@PathVariable int resumeId) {
        resumeService.deleteResume(resumeId);
        return "redirect:/resumes";
    }
}

