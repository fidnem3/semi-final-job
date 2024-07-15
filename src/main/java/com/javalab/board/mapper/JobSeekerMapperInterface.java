package com.javalab.board.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.javalab.board.vo.JobSeekerVo;
/***
 * 멤버 매퍼 인터페이스
 * - JobSeekerService와 JobSeekerMapper.xml을 연결시켜주는 역할
 * @author 재석
 *
 */
//@Mapper
public interface JobSeekerMapperInterface {
	int createJobSeeker(JobSeekerVo jobSeekerVo); //회원가입
	JobSeekerVo getJobSeeker(String jobSeekerId); // 회원 한명 조회
	void updateJobSeekerPoint(String jobSeekerId); // 포인트 지급
	
}
