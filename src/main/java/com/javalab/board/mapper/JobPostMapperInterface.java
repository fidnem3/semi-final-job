package com.javalab.board.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.javalab.board.vo.JobPostVo;

@Mapper
public interface JobPostMapperInterface {

	/**
	 * public VS void 명식적과 암시적 차이 void insertJobPost(JobPostVo jobPost); 접근 제어자를
	 * 명시하지 않았지만 암시적으로 public입니다. public void insertJobPost(JobPostVo jobPost); 접근
	 * 제어자를 명시적으로 선언했습니다.
	 */


	/**
	 * 모든 채용 공고를 조회합니다.
	 * 
	 * @return 모든 채용 공고 목록
	 */
	List<JobPostVo> getAllJobPosts();

	/**
	 * 특정 ID의 채용 공고를 조회합니다.
	 * 
	 * @param jobPostId 조회할 채용 공고의 ID
	 * @return 조회된 채용 공고 정보
	 */
	JobPostVo getJobPostById(String jobPostId);

	/**
	 * 새로운 채용 공고를 등록합니다.
	 * 
	 * @param jobPost 등록할 채용 공고 정보
	 */
	int createJobPost(JobPostVo jobPost);

	/**
	 * 특정 ID의 채용 공고 상세 정보를 조회합니다. 이 메서드는 채용 공고의 모든 세부 정보를 포함하여 반환합니다. 주로 상세 보기 페이지에서
	 * 사용됩니다.
	 * 
	 * @param jobPostId 조회할 채용 공고의 ID
	 * @return 조회된 채용 공고의 상세 정보
	 */
	JobPostVo getJobPostDetail(String jobPostId);

	/**
	 * 기존 채용 공고 정보를 수정합니다.
	 * 
	 * @param jobPost 수정할 채용 공고 정보
	 */
	int updateJobPost(JobPostVo jobPost);

	/**
	 * 특정 ID의 채용 공고를 삭제합니다.
	 * 
	 * @param jobPostId 삭제할 채용 공고의 ID
	 */
	int deleteJobPost(String jobPostId);

	/**
	 * 주어진 필터 조건에 맞는 채용 공고를 조회합니다.
	 * 
	 * @param filters 필터링 조건을 담은 Map (예: 지역, 경력, 학력 등)
	 * @return 필터링된 채용 공고 목록
	 */
	List<JobPostVo> getScrapList(String jobSeekerId);
	
	
	 String getJobPostTitleByJobPostId(int jobPostId);

	/**
	 * 특정 채용 공고의 조회수를 증가시킵니다.
	 * 
	 * @param jobPostId 조회수를 증가시킬 채용 공고의 ID
	 */
	int incrementHitCount(String jobPostId);
}
