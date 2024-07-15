package com.javalab.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javalab.board.service.JobSeekerService;
import com.javalab.board.vo.JobSeekerVo;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/jobSeeker")
@Slf4j
public class JobSeekerController {

	@Autowired
	private JobSeekerService jobSeekerService;

	@GetMapping("/create")
	public String createJobSeeker(Model model) {
		model.addAttribute("jobSeekerVo", new JobSeekerVo());
		return "jobSeeker/jobSeekerCreate";
	}

	@PostMapping("create")
	public String createJobSeeker(@ModelAttribute JobSeekerVo jobSeekerVo) {
		log.info("createJobSeeker 메소드 : " + jobSeekerVo);
		jobSeekerService.createJobSeeker(jobSeekerVo);
		return "redirect:/jobSeeker/list";
	}
	
	@GetMapping("/{jobSeekerId}")
	public String getJobSeeker(@PathVariable("jobSeekerId") String jobSeekerId, Model model) {
		JobSeekerVo jobSeekerVo = jobSeekerService.getJobSeeker(jobSeekerId);
		model.addAttribute("jobSeekerVo", jobSeekerVo);
		return "jobSeeker/jobSeekerDetail";
	}

}
