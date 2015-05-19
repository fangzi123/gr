package com.cyou.gr.dao;

import com.cyou.gr.entity.Checkbill;

public interface CheckbillMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Checkbill record);

    int insertSelective(Checkbill record);

    Checkbill selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Checkbill record);

    int updateByPrimaryKey(Checkbill record);

	Boolean isUsed(Integer checkbillTemplateId);
}