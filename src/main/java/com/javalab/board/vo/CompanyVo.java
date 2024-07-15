package com.javalab.board.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
public class CompanyVo {
	private String compId; // 기업ID
	private int jobPostId;
	private int resumeId;
	private String password; // 기업 비밀번호
	private String email; //기업 이메일
	private String companyName; // 기업명
	private String businessNumber; // 기업 연락처
	private String homepage; // 기업 홈페이지
	private String logoName; // 기업 로고
	private String logoPath; // 로고이미지경로
	private String address; // 기업 주소  
	
}
