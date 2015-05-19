package com.cyou.gr.dao;

import java.util.List;

import com.cyou.gr.entity.FeeTemplate;

public interface FeeTemplateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FeeTemplate record);

    int insertSelective(FeeTemplate record);

    FeeTemplate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FeeTemplate record);

    int updateByPrimaryKey(FeeTemplate record);

	List<FeeTemplate> selectFeetsByprocNodeId(Integer procNodeId);
	
	Byte selectMaxSort(Integer procNodeId);

}