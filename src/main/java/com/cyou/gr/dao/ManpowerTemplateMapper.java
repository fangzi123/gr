package com.cyou.gr.dao;

import java.util.List;

import com.cyou.gr.entity.ManpowerTemplate;

public interface ManpowerTemplateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ManpowerTemplate record);

    int insertSelective(ManpowerTemplate record);

    ManpowerTemplate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ManpowerTemplate record);

    int updateByPrimaryKey(ManpowerTemplate record);

	List<ManpowerTemplate> selectManpowerTsByprocNodeId(Integer procNodeId);

	Byte selectMaxSort(Integer procNodeId);
}