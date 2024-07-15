package com.javalab.board.vo;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class JobPostVo {
	private int jobPostId; // 채용공고ID
	private String compId; // 기업I
	private String title; // 공고제목
	private String content; // 공고 내
	private String position; // 직위
	private String salary; // 연봉
	private String experience; // 경력
	private String education; // 학력
	private String address; // 기업주소
	private int scrapCount; // 스크랩수
	private Date endDate; // 마감기한
	private String homePage; // 기업홉페이지
	private Date created; // 작성일자
	private int hitNO; // 조회수
	private String function; // 기능 또는 직무
	private String job; // 직종 
	private String location; // 근무지 위치

	public JobPostVo(int jobPostId, String title, String content) {
		this.jobPostId = jobPostId;
		this.title = title;
		this.content = content;
	}

	public String getEndDate() {
		return endDate != null ? new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(endDate) : null;
	}

	public String getCreated() {
		return created != null ? new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(created) : null;
	}
}
