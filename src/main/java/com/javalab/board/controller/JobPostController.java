package com.javalab.board.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		// 조회수 증가
		jobPostService.incrementHitCount(jobPostId);
		model.addAttribute("jobPost", jobPost);
		return "jobPost/detail";
	}

	@GetMapping("/create")
	public String createJobPostForm(HttpSession session, Model model) {
		log.info("JobPostController createJobPostForm");
		JobSeekerVo memberVo = (JobSeekerVo) session.getAttribute("memberVo");
		if (memberVo == null) {
			return "redirect:/login";
		}
		model.addAttribute("jobPost", new JobPostVo());
		return "jobPost/form";
	}

	@PostMapping("/create")
	public String createJobPost(@ModelAttribute("jobPost") JobPostVo jobPost, HttpSession session) {
		log.info("JobPostController createJobPost");
		JobSeekerVo memberVo = (JobSeekerVo) session.getAttribute("memberVo");
		if (memberVo == null) {
			return "redirect:/login";
		}
		jobPost.setCompId(memberVo.getJobSeekerId()); // 기업 ID 설정
		jobPostService.insertJobPost(jobPost);
		return "redirect:/jobPost/list";
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
			return "error/403"; // 권한 없음
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
			return "error/403"; // 권한 없음
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
			return "error/403"; // 권한 없음
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