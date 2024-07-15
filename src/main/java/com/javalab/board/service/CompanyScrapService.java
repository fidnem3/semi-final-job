package com.javalab.board.service;

import com.javalab.board.vo.CompanyScrapVo;
import com.javalab.board.mapper.CompanyScrapMapperInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyScrapService {

    @Autowired
    private CompanyScrapMapperInterface mapper;

    public List<CompanyScrapVo> getScrapsByCompId(String compId) {
        return mapper.findByCompId(compId);
    }

    public void saveScrap(CompanyScrapVo scrap) {
        mapper.addScrap(scrap);
    }

    public void deleteScrap(String scrapId) {
        mapper.deleteScrap(scrapId);
    }
}