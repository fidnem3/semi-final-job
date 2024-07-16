package com.javalab.board.service;

import com.javalab.board.mapper.ResumeMapperInterface;
import com.javalab.board.vo.ResumeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private ResumeMapperInterface resumeMapper;

    @Override
    public void createResume(ResumeVo resume) {
        resumeMapper.insertResume(resume);
    }

    @Override
    public ResumeVo getResumeById(int resumeId) {
        return resumeMapper.selectResumeById(resumeId);
    }

    @Override
    public List<ResumeVo> getAllResumes() {
        return resumeMapper.selectAllResumes();
    }

    @Override
    public void updateResume(ResumeVo resume) {
        resumeMapper.updateResume(resume);
    }

    @Override
    public void deleteResume(int resumeId) {
        resumeMapper.deleteResume(resumeId);
    }
}
