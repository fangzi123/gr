package com.cyou.gr.dao;

import java.util.List;

import com.cyou.gr.entity.CheckbillTemplate;

public interface CheckbillTemplateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CheckbillTemplate record);

    int insertSelective(CheckbillTemplate record);

    CheckbillTemplate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CheckbillTemplate record);

    int updateByPrimaryKey(CheckbillTemplate record);

	List<CheckbillTemplate> selectCheckbillTsByProcNodeId(Integer procNodeId);

	Byte selectMaxSort(Integer procNodeId);
}