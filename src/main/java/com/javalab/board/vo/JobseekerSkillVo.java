package com.javalab.board.vo;

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
public class JobseekerSkillVo {
	private int resumeSkillId; //스킬Id
	private int resumeId; //이력서ID
	private String jobSeekerId;
	private String skill; //추가스킬
}
