package com.javalab.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.javalab.board.vo.JobSeekerScrapVo;

@Mapper
public interface JobSeekerScrapMapperInterface {

	  List<JobSeekerScrapVo> findByJobSeekerId(String jobSeekerId);

	    void saveScrap(JobSeekerScrapVo scrap);

	    void deleteScrap(String scrapId);
	}