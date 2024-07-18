




































package com.javalab.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.javalab.board.service.JobSeekerScrapService;
import com.javalab.board.vo.JobSeekerScrapVo;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/jobSeeker")
public class JobSeekerScrapController {

    @Autowired
    private JobSeekerScrapService scrapService;


    // 스크랩 추가 또는 취소
    @PostMapping("/scrap/toggle")
    @ResponseBody
    public ResponseEntity<?> toggleScrap(@RequestBody JobSeekerScrapVo scrap) {
        boolean isScrapped = scrapService.checkIfScrapped(scrap.getJobSeekerId(), scrap.getJobPostId());
        if (isScrapped) {
            scrapService.deleteScrapByJobSeekerIdAndJobPostId(scrap.getJobSeekerId(), scrap.getJobPostId());
            return new ResponseEntity<>("canceled", HttpStatus.OK);
        } else {
            scrapService.insertScrap(scrap);
            return new ResponseEntity<>(scrap.getScrapId(), HttpStatus.OK);
        }
    }
    
    @GetMapping("/scrap/list/{jobSeekerId}")
    public String listJobSeekerScrap(@PathVariable String jobSeekerId, Model model) {
        log.info("여기는 listJobSeekerScrap 메소드");
        List<JobSeekerScrapVo> jobSeekerScrapList = scrapService.getScrapList(jobSeekerId);
        model.addAttribute("scrapList", jobSeekerScrapList); // 속성 이름을 "scrapList"로 수정
        return "board/scrapList"; // JSP 이름
    }

}
    