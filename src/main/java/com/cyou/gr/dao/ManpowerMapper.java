package com.cyou.gr.dao;

import com.cyou.gr.entity.Manpower;

public interface ManpowerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Manpower record);

    int insertSelective(Manpower record);

    Manpower selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Manpower record);

    int updateByPrimaryKey(Manpower record);

	Boolean isUsed(Integer manpowerTemplateId);
}