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
public class ResumeVo { 
    private String resumeId; // 이력서ID
    private String jobSeekerId; // 유저아이디
    private String title; // 제목
    private String content; //내용
    private String education; // 학력
    private String experience; // 경력
    private String link; // 링크
    private int hitNo; // 조회수
    private String fileName; // 파일명
    private String filePath; // 파일주소
}
