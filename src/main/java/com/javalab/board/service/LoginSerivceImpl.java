package com.javalab.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalab.board.mapper.LoginMapperInterface;
import com.javalab.board.vo.JobSeekerVo;

@Service
public class LoginSerivceImpl implements LoginService {

	@Autowired
	private LoginMapperInterface loginMapper;

	@Override
	public JobSeekerVo login(JobSeekerVo jobSeekerVo) {
		JobSeekerVo jobSeekerVo2 = loginMapper.login(jobSeekerVo);
		return jobSeekerVo2;
	}

}
