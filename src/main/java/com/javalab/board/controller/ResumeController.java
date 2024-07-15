package com.javalab.board.controller;

import com.javalab.board.service.ResumeService;
import com.javalab.board.vo.ResumeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/resumes")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @GetMapping
    public String listResumes(Model model) {
        List<ResumeVo> resumes = resumeService.getAllResumes();
        model.addAttribute("resumes", resumes);
        return "resume/list";
    }

    @GetMapping("/new")
    public String newResumeForm(Model model) {
        model.addAttribute("resume", new ResumeVo());
        return "resume/new";
    }

    @PostMapping
    public String createResume(@ModelAttribute ResumeVo resume) {
        resumeService.createResume(resume);
        return "redirect:/resumes";
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
