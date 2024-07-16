package com.javalab.board.mapper;

import com.javalab.board.vo.ResumeVo;
import java.util.List;

public interface ResumeMapperInterface {
    List<ResumeVo> selectAllResumes();
    void insertResume(ResumeVo resume);
    ResumeVo selectResumeById(int resumeId);
    void updateResume(ResumeVo resume);
    void deleteResume(int resumeId);
}
