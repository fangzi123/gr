package com.cyou.gr.dao;

import java.util.List;

import com.cyou.gr.entity.Quota;

public interface QuotaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Quota record);

    int insertSelective(Quota record);

    Quota selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Quota record);

    int updateByPrimaryKey(Quota record);

	List<Quota> selectQuotaList();

	int selectMaxSort();
}