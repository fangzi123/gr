package com.cyou.gr.dao;

import java.util.List;

import com.cyou.gr.entity.ProcessNode;

public interface ProcessNodeMapper {

	int deleteByPrimaryKey(Integer id);

    int insert(ProcessNode record);

    int insertSelective(ProcessNode record);

    ProcessNode selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProcessNode record);

    int updateByPrimaryKey(ProcessNode record);

	List<ProcessNode> selectProcNodeListByProcId(Integer procId);

	Integer selectMaxSort();
}