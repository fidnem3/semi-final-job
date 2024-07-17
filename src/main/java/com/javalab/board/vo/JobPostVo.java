package com.javalab.board.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

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
	private String compId; // 기업ID
	private String title; // 공고제목
	private String content; // 공고 내용
	private String position; // 직위
	private String salary; // 연봉
	private String experience; // 경력
	private String education; // 학력
	private String address; // 기업주소
	private int scrapCount; // 스크랩수
	private String homePage; // 기업홈페이지
	private int hitNo; // 조회수
	private String fileName; // 파일 이름 
	private String filePath; // 파일 주소

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate; // 마감기한

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date created; // 작성일자

	// 기본 생성자와 모든 필드를 포함하는 생성자는 Lombok에 의해 자동 생성됩니다.

	// 특정 필드만을 위한 생성자
	public JobPostVo(int jobPostId, String title, String content) {
		this.jobPostId = jobPostId;
		this.title = title;
		this.content = content;
	}
}