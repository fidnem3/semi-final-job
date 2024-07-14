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
public class RequiredSkillVo {
	   private String requiredSkillId; // 필요스킬 ID
	    private String jobPostId; //채용Id
	    private String skill; // 기술
}
