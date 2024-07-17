package com.javalab.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.javalab.board.vo.JobSeekerScrapVo;

@Mapper
public interface JobSeekerScrapMapperInterface {

	  @Select("SELECT CASE WHEN COUNT(*) > 0 THEN 1 ELSE 0 END FROM jobSeeker_scrap WHERE jobSeekerId = #{jobSeekerId} AND jobPostId = #{jobPostId}")
	    boolean existsByJobSeekerIdAndJobPostId(@Param("jobSeekerId") String jobSeekerId, @Param("jobPostId") int jobPostId);


	void insertScrap(JobSeekerScrapVo scrap);

	void deleteScrap(@Param("scrapId") int scrapId);

	List<JobSeekerScrapVo> getScrapList(@Param("jobSeekerId") String jobSeekerId);
	
	@Delete("DELETE FROM jobSeeker_scrap WHERE jobSeekerId = #{jobSeekerId} AND jobPostId = #{jobPostId}")
    void deleteScrapByJobSeekerIdAndJobPostId(@Param("jobSeekerId") String jobSeekerId, @Param("jobPostId") int jobPostId);
	
	public List<JobSeekerScrapVo> listJobSeekerScrap();

}