package com.javalab.board.vo;

import java.security.Timestamp;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString

public class JobSeekerScrapVo {
    private int scrapId; // 스크랩Id
    private String jobSeekerId; //유저아이디
    private String jobPostId; //채용공고ID
    private Date created; //스크랩날짜
}
