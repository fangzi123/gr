package com.cyou.gr.service;

import java.util.List;

import com.cyou.gr.entity.Document;

public interface DocumentService {

	List<Document> selectDocList(Document doc);

	void deleteDocById(Integer id);

	void saveOrUpdate(Document doc);

}
