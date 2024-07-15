package com.javalab.board.controller;

import com.javalab.board.service.JobSeekerScrapService;
import com.javalab.board.vo.JobSeekerScrapVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/scrap")
public class ScrapController {

    private final JobSeekerScrapService jobSeekerScrapService;

    @Autowired
    public ScrapController(JobSeekerScrapService jobSeekerScrapService) {
        this.jobSeekerScrapService = jobSeekerScrapService;
    }

    @GetMapping("/jobSeeker")
    public String viewJobSeekerScraps(Model model, Principal principal) {
        if (principal == null) {
            return "redirect:/login"; // 로그인 페이지로 리다이렉트
        }

        String jobSeekerId = principal.getName();
        List<JobSeekerScrapVo> scraps = jobSeekerScrapService.getScrapsByJobSeekerId(jobSeekerId);
        model.addAttribute("scraps", scraps);
        return "jobSeekerScrap"; // jobSeekerScrap.jsp와 연결될 뷰 이름
    }

    @PostMapping("/jobSeeker/add")
    @ResponseBody
    public String addJobSeekerScrap(@RequestParam("jobPostId") String jobPostId, Principal principal) {
        if (principal == null) {
            return "redirect:/login"; // 로그인 페이지로 리다이렉트
        }

        String jobSeekerId = principal.getName();
        JobSeekerScrapVo scrap = new JobSeekerScrapVo();
        scrap.setJobSeekerId(jobSeekerId);
        scrap.setJobPostId(jobPostId);

        jobSeekerScrapService.addJobSeekerScrap(scrap);
        return "success";
    }

    @PostMapping("/jobSeeker/delete")
    @ResponseBody
    public String deleteJobSeekerScrap(@RequestParam("scrapId") String scrapId) {
        jobSeekerScrapService.deleteJobSeekerScrap(scrapId);
        return "success";
    }
}
