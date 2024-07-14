package com.javalab.board.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * MemberVO 자바빈즈 클래스 - JSP, Servlet 간의 데이터 이동시 사용 - private 멤버변수, 게터/세터, 기본생성자
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MemberVo {
	private String memberId;
	private String password;
	private String name;
	private String email;
	private int point;

	// 비밀번호를 제외한 나머지 정보만 세션에 보관하기 위해서 별도로 생성자 정의
	public MemberVo(String memberId, String password, String name, String email) {
		this.memberId = memberId;
		this.password = password;
		this.name = name;
		this.email = email;
	}
	
	public MemberVo(String memberId, String name, String email) {
		this.memberId = memberId;
		this.name = name;
		this.email = email;
	}

	// 로그인을 위한 생성자
	public MemberVo(String memberId, String password) {
		this.memberId = memberId;
		this.password = password;
	}

}