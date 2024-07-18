package com.javalab.board.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.javalab.board.service.JobPostService;
import com.javalab.board.vo.JobPostVo;
import com.javalab.board.vo.JobSeekerVo;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/jobPost")
@Slf4j
public class JobPostController {

	@Autowired
	private JobPostService jobPostService;
	

	@GetMapping("/list")
	public String listJobPosts(Model model) {
	    log.info("JobPostController listJobPosts");
	    List<JobPostVo> jobPosts = jobPostService.getAllJobPosts();
	    
	    // 각 JobPostVo 객체의 fileName과 filePath 로깅
	    for (JobPostVo post : jobPosts) {
	        log.info("JobPost: id={}, title={}, fileName={}, filePath={}", 
	                 post.getJobPostId(), post.getTitle(), post.getFileName(), post.getFilePath());
	    }
	    
	    model.addAttribute("jobPosts", jobPosts);
	    return "jobPost/list";
	}

	@GetMapping("/detail/{id}")
	public String getJobPostDetail(@PathVariable("id") String jobPostId, Model model) {
		log.info("JobPostController getJobPostDetail: id = {}", jobPostId);
		JobPostVo jobPost = jobPostService.getJobPostById(jobPostId);
		if (jobPost == null) {
			return "error/404";
		}

		jobPostService.incrementHitCount(jobPostId);
		model.addAttribute("jobPost", jobPost);
		return "jobPost/detail";
	}

	@GetMapping("/create")
	public String createJobPostForm(HttpSession session, Model model) {
		log.info("JobPostController createJobPostForm");
		JobSeekerVo jobSeekerVo = (JobSeekerVo) session.getAttribute("jobSeekerVo");
		if (jobSeekerVo == null) {
			return "redirect:/login";
		}
		model.addAttribute("jobPost", new JobPostVo());
		return "jobPost/form";
	}

	@PostMapping("/create")
	public String createJobPost(@ModelAttribute("jobPost") JobPostVo jobPost, BindingResult bindingResult,
	        @RequestParam("file") MultipartFile file, HttpSession session,
	        RedirectAttributes redirectAttributes, HttpServletRequest request) {
	    log.info("JobPostController createJobPost - Received jobPost: {}", jobPost);

	    JobSeekerVo jobSeekerVo = (JobSeekerVo) session.getAttribute("jobSeekerVo");
	    if (jobSeekerVo == null) {
	        log.error("JobSeekerVo not found in session");
	        return "redirect:/login";
	    }

	    if (bindingResult.hasErrors()) {
	        log.error("Validation errors: {}", bindingResult.getAllErrors());
	        return "jobPost/form";
	    }

	    if (jobPost.getEndDate() == null) {
	        bindingResult.rejectValue("endDate", "error.endDate", "마감일은 필수입니다.");
	        return "jobPost/form";
	    }

	    try {
	        // 날짜 형식 변환
	        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
	        String formattedDate = outputFormat.format(jobPost.getEndDate());
	        jobPost.setEndDate(outputFormat.parse(formattedDate));

	        String uploadDir = "C:\\filetest\\upload";
	        String webAccessPath = "/uploads/";

	        if (!file.isEmpty()) {
	            try {
	                String originalFileName = file.getOriginalFilename();
	                String uniqueFileName = System.currentTimeMillis() + "_" + originalFileName;
	                File dest = new File(uploadDir + uniqueFileName);
	                file.transferTo(dest);

	                jobPost.setFileName(originalFileName);
	                jobPost.setFilePath("/uploads/" + uniqueFileName);
	            } catch (IOException e) {
	                log.error("파일 업로드 실패", e);
	                redirectAttributes.addFlashAttribute("error", "파일 업로드 중 오류가 발생했습니다: " + e.getMessage());
	                return "jobPost/form";
	            }
	        }

	        jobPost.setCompId(jobPost.getCompId()); // jobSeekerVo에서 compId를 가져옵니다.
	        jobPost.setScrapCount(0);
	        jobPostService.createJobPost(jobPost);
	        redirectAttributes.addFlashAttribute("message", "채용 공고가 성공적으로 등록되었습니다.");
	        return "redirect:/jobPost/list";
	    } catch (ParseException e) {
	        log.error("Date parsing error", e);
	        bindingResult.rejectValue("endDate", "error.endDate", "날짜 형식이 올바르지 않습니다.");
	        return "jobPost/form";
	    } catch (Exception e) {
	        log.error("Error creating job post", e);
	        redirectAttributes.addFlashAttribute("error", "채용 공고 등록 중 오류가 발생했습니다: " + e.getMessage());
	        return "jobPost/form";
	    }
	}

	@GetMapping("/edit/{id}")
	public String editJobPostForm(@PathVariable("id") String jobPostId, Model model) {
	    log.info("JobPostController editJobPostForm: id = {}", jobPostId);
	    
	    JobPostVo jobPost = jobPostService.getJobPostById(jobPostId);
	    if (jobPost == null) {
	        log.warn("JobPost not found for ID: {}", jobPostId);
	        return "error/404error";
	    }
	    
	    model.addAttribute("jobPost", jobPost);
	    return "jobPost/update";
	}

	@PostMapping("/update")
	public String updateJobPost(@ModelAttribute("jobPost") JobPostVo jobPost) {
	    log.info("JobPostController updateJobPost: id = {}", jobPost.getJobPostId());
	    
	    jobPostService.updateJobPost(jobPost);
	    return "redirect:/jobPost/list";
	}

	@PostMapping("/delete")
	@ResponseBody
	public String deleteJobPost(@RequestParam("id") String jobPostId) {
	    log.info("JobPostController deleteJobPost: id = {}", jobPostId);
	    jobPostService.deleteJobPost(jobPostId);
	    return "success";
	}







	@GetMapping("/scrapList")
	public String scrapList(Model model, HttpSession session) {
		// 세션에서 로그인한 사용자의 아이디를 가져옵니다.
		String jobSeekerId = ((JobSeekerVo) session.getAttribute("jobSeekerVo")).getJobSeekerId();

		// 사용자의 아이디를 기반으로 스크랩 목록을 조회합니다.
		List<JobPostVo> scrapList = jobPostService.getScrapList(jobSeekerId);

		// 각 게시물의 제목 데이터를 설정하여 JobPostVo 객체에 저장합니다.
		for (JobPostVo jobPost : scrapList) {
			String title = jobPostService.getJobPostTitleByJobPostId(jobPost.getJobPostId());
			jobPost.setTitle(title); // JobPostVo 객체에 제목 설정
		}

		// 모델에 스크랩 목록을 추가하여 JSP로 전달합니다.
		model.addAttribute("scrapList", scrapList);

		return "board/scrapList"; // scrapList.jsp로 포워딩
	}
}