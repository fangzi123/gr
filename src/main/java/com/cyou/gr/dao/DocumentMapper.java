package com.cyou.gr.dao;

import java.util.List;

import com.cyou.gr.entity.Document;

public interface DocumentMapper {

	int deleteByPrimaryKey(Integer id);

	int insert(Document record);

	int insertSelective(Document record);

	Document selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Document record);

	int updateByPrimaryKey(Document record);

	List<Document> selectDocList();
}