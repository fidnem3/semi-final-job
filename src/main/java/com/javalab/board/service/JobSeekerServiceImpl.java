package com.javalab.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javalab.board.mapper.JobSeekerMapperInterface;
import com.javalab.board.vo.JobSeekerVo;

/**
 * 멤버 서비스 인터페이스 구현체 - 실제로 비지니스 로직이 구현되는 클래스
 * 
 * @author 재석
 *
 */
@Service
public class JobSeekerServiceImpl implements JobSeekerService {

	@Autowired
	private JobSeekerMapperInterface jobSeekerMapper;

	@Override
	public int createJobSeeker(JobSeekerVo jobSeekerVo) {
		int result = jobSeekerMapper.createJobSeeker(jobSeekerVo);
		return result;
	}


	@Override
	public JobSeekerVo getJobSeeker(String jobSeekerId) {
		return jobSeekerMapper.getJobSeeker(jobSeekerId);
	}
	
	@Override
	@Transactional
	public void updateJobSeekerPoint(String jobSeekerId) {
		jobSeekerMapper.updateJobSeekerPoint(jobSeekerId);
	}
}
