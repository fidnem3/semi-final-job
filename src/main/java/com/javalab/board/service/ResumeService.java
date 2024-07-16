package com.javalab.board.service;

import com.javalab.board.vo.ResumeVo;
import java.util.List;

public interface ResumeService {
    void createResume(ResumeVo resume);
    ResumeVo getResumeById(int resumeId);
    List<ResumeVo> getAllResumes();
    void updateResume(ResumeVo resume);
    void deleteResume(int resumeId);
}
