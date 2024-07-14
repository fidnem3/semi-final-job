package com.javalab.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javalab.board.mapper.MemberMapperInterface;
import com.javalab.board.vo.MemberVo;

/**
 * 멤버 서비스 인터페이스 구현체 - 실제로 비지니스 로직이 구현되는 클래스
 * 
 * @author 재석
 *
 */
@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapperInterface memberMapper;

	@Override
	public int createMember(MemberVo memberVo) {
		int result = memberMapper.createMember(memberVo);
		return result;
	}

	@Override
	@Transactional
	public void updateMemberPoint(String memberId) {
		memberMapper.updateMemberPoint(memberId);
	}

	@Override
	public MemberVo getMember(String memberId) {
		return memberMapper.getMember(memberId);
	}
}
