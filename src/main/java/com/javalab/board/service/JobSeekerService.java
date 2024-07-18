package com.javalab.board.service;

import org.apache.ibatis.annotations.Mapper;

import com.javalab.board.vo.JobSeekerVo;


/**
 * JobSeeker 서비스 인터페이스
 * - 비지니스 로직이 구현되는 헤이러
 */

public interface JobSeekerService {
	int createJobSeeker(JobSeekerVo jobSeekerVo);
	void updateJobSeekerPoint(String point);
	JobSeekerVo getJobSeeker(String jobSeekerId);
	
}
