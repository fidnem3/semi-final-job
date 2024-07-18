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
public class JobSeekerVo {
	private String jobSeekerId; // 유저아이디
	private String email; // 이메일
	private String password; // 비밀번호
	private String name; // 이름
	private String tel; // 연락처
	private String fileName; // 파일명
	private String filePath; // 파일주소 
	private String address; // 주소
	
	
}
