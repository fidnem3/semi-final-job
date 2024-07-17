package com.javalab.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
			HttpSession session, RedirectAttributes redirectAttributes) {
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

		// 날짜가 null인 경우 처리
		if (jobPost.getEndDate() == null) {
			bindingResult.rejectValue("endDate", "error.endDate", "마감일은 필수입니다.");
			return "jobPost/form";
		}

		try {
			jobPost.setCompId(jobPost.getCompId());
			jobPost.setScrapCount(0);
			jobPostService.createJobPost(jobPost);
			redirectAttributes.addFlashAttribute("message", "채용 공고가 성공적으로 등록되었습니다.");
			return "redirect:/jobPost/list";
		} catch (Exception e) {
			log.error("Error creating job post", e);
			redirectAttributes.addFlashAttribute("error", "채용 공고 등록 중 오류가 발생했습니다: " + e.getMessage());
			return "jobPost/form";
		}
	}

	@GetMapping("/edit/{id}")
	public String editJobPostForm(@PathVariable("id") String jobPostId, Model model, HttpSession session) {
		log.info("JobPostController editJobPostForm: id = {}", jobPostId);
		JobSeekerVo memberVo = (JobSeekerVo) session.getAttribute("memberVo");
		if (memberVo == null) {
			return "redirect:/login";
		}
		JobPostVo jobPost = jobPostService.getJobPostById(jobPostId);
		if (!jobPost.getCompId().equals(memberVo.getJobSeekerId())) {
			return "error/404"; // 권한 없음
		}
		model.addAttribute("jobPost", jobPost);
		return "jobPost/form";
	}

	@PostMapping("/update")
	public String updateJobPost(@ModelAttribute("jobPost") JobPostVo jobPost, HttpSession session) {
		log.info("JobPostController updateJobPost: id = {}", jobPost.getJobPostId());
		JobSeekerVo memberVo = (JobSeekerVo) session.getAttribute("memberVo");
		if (memberVo == null) {
			return "redirect:/login";
		}
		if (!jobPost.getCompId().equals(memberVo.getJobSeekerId())) {
			return "error/404"; // 권한 없음
		}
		jobPostService.updateJobPost(jobPost);
		return "redirect:/jobPost/list";
	}

	@PostMapping("/delete")
	public String deleteJobPost(@RequestParam("id") String jobPostId, HttpSession session) {
		log.info("JobPostController deleteJobPost: id = {}", jobPostId);
		JobSeekerVo memberVo = (JobSeekerVo) session.getAttribute("memberVo");
		if (memberVo == null) {
			return "redirect:/login";
		}
		JobPostVo jobPost = jobPostService.getJobPostById(jobPostId);
		if (!jobPost.getCompId().equals(memberVo.getJobSeekerId())) {
			return "error/404"; // 권한 없음
		}
		jobPostService.deleteJobPost(jobPostId);
		return "redirect:/jobPost/list";
	}

	@PostMapping("/scrap/{id}")
	public String scrapJobPost(@PathVariable("id") String jobPostId, HttpSession session) {
		log.info("JobPostController scrapJobPost: id = {}", jobPostId);
		JobSeekerVo memberVo = (JobSeekerVo) session.getAttribute("memberVo");
		if (memberVo == null) {
			return "redirect:/login";
		}
		jobPostService.incrementHitCount(jobPostId);
		// 여기에 스크랩 저장 로직 추가
		return "redirect:/jobPost/detail/" + jobPostId;
	}
}