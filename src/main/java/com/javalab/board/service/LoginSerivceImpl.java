package com.javalab.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalab.board.mapper.LoginMapperInterface;
import com.javalab.board.vo.MemberVo;

@Service
public class LoginSerivceImpl implements LoginService {

	@Autowired
	private LoginMapperInterface loginMapper;

	@Override
	public MemberVo login(MemberVo memberVo) {
		MemberVo memberVo2 = loginMapper.login(memberVo);
		return memberVo2;
	}

}
