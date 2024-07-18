package com.javalab.board.mapper;

import com.javalab.board.vo.ResumeSkillVo;
import com.javalab.board.vo.ResumeVo;
import java.util.List;

public interface ResumeMapperInterface {
    List<ResumeVo> getAllResumes();
    void insertResume(ResumeVo resume);
    ResumeVo selectResumeById(int resumeId);
    int updateResume(ResumeVo resume);
    void deleteResume(int resumeId);
    void insertSkill(ResumeSkillVo resumeSkill);
}
