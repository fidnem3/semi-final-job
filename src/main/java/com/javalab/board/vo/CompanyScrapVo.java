package com.javalab.board.vo;

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
public class CompanyScrapVo {
    private String scrapId; // 스크랩ID
    private String compId; // 기업ID
    private String resumeId; //이력서ID
    private Timestamp created; //스크랩날짜
}
