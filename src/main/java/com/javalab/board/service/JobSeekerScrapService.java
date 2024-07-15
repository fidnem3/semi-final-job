package com.javalab.board.service;

import com.javalab.board.vo.JobSeekerScrapVo;
import com.javalab.board.mapper.JobSeekerScrapMapperInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerScrapService {

    @Autowired
    private JobSeekerScrapMapperInterface mapper;

    public List<JobSeekerScrapVo> getScrapsByJobSeekerId(String jobSeekerId) {
        return mapper.findByJobSeekerId(jobSeekerId);
    }

    public void addJobSeekerScrap(JobSeekerScrapVo scrap) {
        mapper.saveScrap(scrap);
    }

    public void deleteJobSeekerScrap(String scrapId) {
        mapper.deleteScrap(scrapId);
    }
}


