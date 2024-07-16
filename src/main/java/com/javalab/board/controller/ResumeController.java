package com.javalab.board.controller;

import com.javalab.board.service.JobSeekerService;
import com.javalab.board.service.ResumeService;
import com.javalab.board.vo.JobSeekerVo;
import com.javalab.board.vo.ResumeVo;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/resumes")
@Slf4j
public class ResumeController {

    @Autowired
    private ResumeService resumeService;
    
    @Autowired
    private JobSeekerService jobSeekerService;
    
    @GetMapping
    public String listResumes(Model model) {
        List<ResumeVo> resumes = resumeService.getAllResumes();
        model.addAttribute("resumes", resumes);
        return "resume/list";
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
    @ResponseBody
    public ResponseEntity<?> createResumeAjax(@RequestBody ResumeVo resume) {
        try {
            resumeService.createResume(resume);
            return ResponseEntity.ok().body(Map.of("msg", "이력서가 성공적으로 저장되었습니다."));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("msg", "이력서 저장 중 오류가 발생했습니다."));
        }
    }

    @GetMapping("/{resumeId}")
    public String viewResume(@PathVariable String resumeId, Model model) {
        ResumeVo resume = resumeService.getResumeById(resumeId);
        model.addAttribute("resume", resume);
        return "resume/view";
    }

    @GetMapping("/{resumeId}/edit")
    public String editResumeForm(@PathVariable String resumeId, Model model) {
        ResumeVo resume = resumeService.getResumeById(resumeId);
        model.addAttribute("resume", resume);
        return "resume/edit";
    }

    @PostMapping("/{resumeId}")
    public String updateResume(@PathVariable int resumeId, @ModelAttribute ResumeVo resume) {
        resume.setResumeId(resumeId);
        resumeService.updateResume(resume);
        return "redirect:/resumes";
    }

    @PostMapping("/{resumeId}/delete")
    public String deleteResume(@PathVariable String resumeId) {
        resumeService.deleteResume(resumeId);
        return "redirect:/resumes";
    }
}

