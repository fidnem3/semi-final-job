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
@Mapper
public interface JobSeekerMapperInterface {
    int createJobSeeker(JobSeekerVo jobSeekerVo);
    void updateJobSeekerPoint(String jobSeekerId);
    JobSeekerVo getJobSeeker(String jobSeekerId);
	
}
