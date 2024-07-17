package com.javalab.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalab.board.mapper.JobSeekerScrapMapperInterface;
import com.javalab.board.vo.JobSeekerScrapVo;

@Service
public class JobSeekerScrapService {

    @Autowired
    private JobSeekerScrapMapperInterface scrapMapper;

    public boolean checkIfScrapped(String jobSeekerId, int jobPostId) {
    	return scrapMapper.existsByJobSeekerIdAndJobPostId(jobSeekerId, jobPostId);
    }
    
    public void insertScrap(JobSeekerScrapVo scrap) {
        boolean isScrapped = scrapMapper.existsByJobSeekerIdAndJobPostId(scrap.getJobSeekerId(), scrap.getJobPostId());
        if (isScrapped) {
            // 이미 스크랩된 경우 스크랩 삭제
            deleteScrap(scrap.getScrapId());
        } else {
            // 스크랩 추가
            scrapMapper.insertScrap(scrap);
        }
    }

    public void deleteScrap(int scrapId) {
        scrapMapper.deleteScrap(scrapId);
    }

    public void deleteScrapByJobSeekerIdAndJobPostId(String jobSeekerId, int jobPostId) {
        scrapMapper.deleteScrapByJobSeekerIdAndJobPostId(jobSeekerId, jobPostId);
    }

	
	  public List<JobSeekerScrapVo> getScrapList(String jobSeekerId) { return
	  scrapMapper.getScrapList(jobSeekerId); }
	 
    
  
}