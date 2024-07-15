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
	   private int requiredSkillId; // 필요스킬 ID
	    private int jobPostId; //채용Id
	    private String compId; // 기술
	    private String skill; // 기술
}
