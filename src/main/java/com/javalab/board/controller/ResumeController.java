package com.javalab.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.javalab.board.service.JobSeekerService;
import com.javalab.board.service.ResumeService;
import com.javalab.board.vo.JobSeekerVo;
import com.javalab.board.vo.ResumeVo;

import lombok.extern.slf4j.Slf4j;

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
    public String listResumes(Model model ,HttpSession session) {
    	
 	    String jobSeekerId = (String) session.getAttribute("jobSeekerId");
        JobSeekerVo jobSeekerVo = jobSeekerService.getJobSeeker(jobSeekerId);  	
        
        List<ResumeVo> resumes = resumeService.getAllResumes();
        // Resumes를 resumeId 기준으로 정렬
        resumes.sort(Comparator.comparingInt(ResumeVo::getResumeId));

        model.addAttribute("jobSeekerVo", jobSeekerVo);
        model.addAttribute("resumes", resumes);
        return "resume/list"; //jsp 이름
    }

    
    //이력서 작성 폼
    @GetMapping("/new")
    public String newResumeForm(Model model ,HttpSession session) {
        // 세션에서 사용자 정보 조회 (예: 세션에 저장된 jobSeekerId를 사용)
  	    String jobSeekerId = (String) session.getAttribute("jobSeekerId");
  	    
        JobSeekerVo jobSeekerVo = jobSeekerService.getJobSeeker(jobSeekerId);  	
        
        // 개인 신상 정보 조회
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

	
	  // AJAX 방식 //이력서 작성 로직
	  
		@PostMapping("/write")
		@ResponseBody
		public ResponseEntity<?> createResumeAjax(@RequestBody ResumeVo resume) {
			try {
				resumeService.createResume(resume);
				return ResponseEntity.ok().body(Map.of("redirectUrl", "/resumes/", "msg", "이력서가 성공적으로 저장되었습니다."));
			} catch (Exception e) {
				return ResponseEntity.badRequest().body(Map.of("msg", "이력서 저장 중 오류가 발생했습니다."));
			}
		}
		
	 

		//이력서 보기
		@GetMapping("/{resumeId}")
		public String viewResume(@PathVariable int resumeId, Model model ,HttpSession session) {
			
	  	    String jobSeekerId = (String) session.getAttribute("jobSeekerId");
			JobSeekerVo jobSeekerVo = jobSeekerService.getJobSeeker(jobSeekerId);
			
			model.addAttribute("jobSeekerVo", jobSeekerVo);
			ResumeVo resume = resumeService.getResumeById(resumeId);
			model.addAttribute("resume", resume);
			return "resume/view";
		}
	      
		// 	 업데이트
	      	@GetMapping("/{resumeId}/edit")
	      	public String editResumeForm(@PathVariable int resumeId, Model model) {
	        ResumeVo resume = resumeService.getResumeById(resumeId);
	        
	        model.addAttribute("resume", resume);
	        return "resume/edit";
	    }
	      	
		/*
		 * @PostMapping("/{resumeId}/update") public ResponseEntity<String>
		 * updateResume(@PathVariable int resumeId,
		 * 
		 * @RequestBody ResumeVo resume, HttpSession session) {
		 * 
		 * // 로그로 받은 이력서 ID 확인 log.info("Updating resume with ID: " + resumeId);
		 * 
		 * // 세션에서 사용자 정보 가져오기 String jobSeekerId = (String)
		 * session.getAttribute("jobSeekerId"); if (jobSeekerId == null) { return
		 * ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized"); }
		 * 
		 * // 이력서 ID와 사용자 ID 설정 resume.setResumeId(resumeId);
		 * resume.setJobSeekerId(jobSeekerId);
		 * 
		 * // 이력서 업데이트 로직 (예: 데이터베이스 업데이트) int result =
		 * resumeService.updateResume(resume); // 데이터베이스 업데이트 호출
		 * 
		 * if (result > 0) { return ResponseEntity.ok("Resume updated successfully"); }
		 * else { return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
		 * body("Failed to update resume"); } }
		 */
    
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
	      	
	      	
	      	//이력서 수정
	      	@PostMapping("/{resumeId}/update")
	      	public ResponseEntity<String> updateResume(@PathVariable int resumeId, 
	      	                                           @RequestBody ResumeVo resume, 
	      	                                           HttpSession session) {


	      	    // 세션에서 jobSeekerId를 가져옴
				
				 String jobSeekerId = (String) session.getAttribute("jobSeekerId");
				 JobSeekerVo jobSeekerVo = (JobSeekerVo) session.getAttribute("jobSeekerVo");
				 
		  	
	      	    if (jobSeekerId == null) {
	      	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
	      	    }

	      	    resume.setResumeId(resumeId);
	      	    resume.setJobSeekerId(jobSeekerId);

	      	    try {
	      	        int result = resumeService.updateResume(resume); // 데이터베이스 업데이트 호출
	      	        if (result > 0) {
	      	            return ResponseEntity.ok("업데이트 성공");
	      	        } else {
	      	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("업데이트 실패");
	      	        }
	      	    } catch (Exception e) {
	      	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("에러 발생");
	      	    }
	      	}

	      
    @PostMapping("/{resumeId}/delete")
    public String deleteResume(@PathVariable int resumeId) {
        resumeService.deleteResume(resumeId);
        return "redirect:/resumes";
    }
}

