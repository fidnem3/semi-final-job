package com.javalab.board.service;

import com.javalab.board.vo.ResumeVo;
import java.util.List;

public interface ResumeService {
    void createResume(ResumeVo resume);
    public ResumeVo getResumeById(int resumeId);
    public List<ResumeVo> getAllResumes();
    int updateResume(ResumeVo resume);
    void deleteResume(int resumeId);
    void insertSkills(int resumeId, List<String> skills);
}
