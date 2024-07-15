package com.javalab.board.vo;


import java.sql.Date;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
public class ApplicationVo {
	private int applicationId; // 입사지원ID
    private String resumeId;  // 이력서ID
    private String jobPostId; //공고Id
    private Date created; // 작성일자
}
