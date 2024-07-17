package com.javalab.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalab.board.mapper.JobPostMapperInterface;
import com.javalab.board.vo.JobPostVo;

import lombok.extern.slf4j.Slf4j;

/**
 * JobPostServiceImpl 클래스 채용 공고 관련 비즈니스 로직을 처리하는 서비스 구현 클래스입니다. JobPostService
 * 인터페이스를 구현하며, 실제 데이터 처리는 JobPostMapper를 통해 수행합니다.
 */
@Service
@Slf4j
public class JobPostServiceImpl implements JobPostService {

	@Autowired
	private JobPostMapperInterface jobPostMapper;

	/**
	 * 모든 채용 공고를 조회합니다.
	 * 
	 * @return 전체 채용 공고 목록
	 */
	@Override
	public List<JobPostVo> getAllJobPosts() {
		log.info("모든 채용 공고를 조회합니다.");
		return jobPostMapper.getAllJobPosts();
	}

	/**
	 * 특정 ID의 채용 공고를 조회합니다.
	 * 
	 * @param jobPostId 조회할 채용 공고의 ID
	 * @return 조회된 채용 공고 정보
	 */
	@Override
	public JobPostVo getJobPostById(String jobPostId) {
		log.info("ID가 {}인 채용 공고를 조회합니다.", jobPostId);
		return jobPostMapper.getJobPostById(jobPostId);
	}

	/**
	 * 새로운 채용 공고를 등록합니다.
	 * 
	 * @param jobPost 등록할 채용 공고 정보
	 * @return 등록된 채용 공고의 ID
	 */
	@Override
	public int createJobPost(JobPostVo jobPost) {
		log.info("새로운 채용 공고를 등록합니다: {}", jobPost);
		return jobPostMapper.createJobPost(jobPost);
	}

	/**
	 * 기존 채용 공고 정보를 수정합니다.
	 * 
	 * @param jobPost 수정할 채용 공고 정보
	 * @return 수정된 행의 수
	 */
	@Override
	public int updateJobPost(JobPostVo jobPost) {
		log.info("채용 공고를 수정합니다: {}", jobPost);
		return jobPostMapper.updateJobPost(jobPost);
	}

	/**
	 * 특정 ID의 채용 공고를 삭제합니다.
	 * 
	 * @param jobPostId 삭제할 채용 공고의 ID
	 * @return 삭제된 행의 수
	 */
	@Override
	public int deleteJobPost(String jobPostId) {
		log.info("ID가 {}인 채용 공고를 삭제합니다.", jobPostId);
		return jobPostMapper.deleteJobPost(jobPostId);
	}

	/**
	 * 주어진 필터 조건에 맞는 채용 공고를 조회합니다.
	 * 
	 * @param filters 필터링 조건을 담은 Map (예: 지역, 경력, 학력 등)
	 * @return 필터링된 채용 공고 목록
	 */
	@Override
    public List<JobPostVo> getScrapList(String jobSeekerId) {
        return jobPostMapper.getScrapList(jobSeekerId);
    }
    
    @Override
    public String getJobPostTitleByJobPostId(int jobPostId) {
        return jobPostMapper.getJobPostTitleByJobPostId(jobPostId);
    }

	/**
	 * 특정 채용 공고의 조회수를 증가시킵니다.
	 * 
	 * @param jobPostId 조회수를 증가시킬 채용 공고의 ID
	 * @return 증가된 행의 수
	 */
	@Override
	public int incrementHitCount(String jobPostId) {
		log.info("ID가 {}인 채용 공고의 조회수를 증가시킵니다.", jobPostId);
		return jobPostMapper.incrementHitCount(jobPostId);
	}

	/**
	 * 특정 ID의 채용 공고 상세 정보를 조회합니다. 이 메서드는 채용 공고의 모든 세부 정보를 포함하여 반환합니다. 주로 상세 보기 페이지에서
	 * 사용됩니다.
	 * 
	 * @param jobPostId 조회할 채용 공고의 ID
	 * @return 조회된 채용 공고의 상세 정보
	 */
	@Override
	public JobPostVo getJobPostDetail(String jobPostId) {
		log.info("ID가 {}인 채용 공고의 상세 정보를 조회합니다.", jobPostId);
		return jobPostMapper.getJobPostDetail(jobPostId);
	}
}