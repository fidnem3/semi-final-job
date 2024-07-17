package com.javalab.board.service;

import com.javalab.board.mapper.ResumeMapperInterface;
import com.javalab.board.vo.ResumeSkillVo;
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
        return resumeMapper.getAllResumes();
    }

    @Override
    public void updateResume(ResumeVo resume) {
        resumeMapper.updateResume(resume);
    }
    
    

    @Override
    public void deleteResume(int resumeId) {
        resumeMapper.deleteResume(resumeId);
    }
    
    @Override
    public void insertSkills(int resumeId, List<String> skills) {
        for (String skill : skills) {
            ResumeSkillVo resumeSkill = new ResumeSkillVo();
            resumeSkill.setResumeId(resumeId);
            resumeSkill.setSkill(skill);
            resumeMapper.insertSkill(resumeSkill);
        }
    }
}


