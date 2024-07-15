package com.javalab.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.javalab.board.vo.CompanyScrapVo;

@Mapper
public interface CompanyScrapMapperInterface {
	List<CompanyScrapVo> findByCompId(String compId);

    void addScrap(CompanyScrapVo scrap);

    void deleteScrap(String scrapId);
}