package com.javalab.board.service;

import com.javalab.board.vo.MemberVo;


/**
 * Member 서비스 인터페이스
 * - 비지니스 로직이 구현되는 헤이러
 */
public interface MemberService {
	int createMember(MemberVo memberVo);
	void updateMemberPoint(String point);
	MemberVo getMember(String memberId);
	
}
