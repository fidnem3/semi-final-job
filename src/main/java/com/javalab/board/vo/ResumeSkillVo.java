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
public class ResumeSkillVo {
	private String resumeSkillId; //스킬Id
	private String resumeId; //이력서ID
	private String skill; //추가스킬
}
