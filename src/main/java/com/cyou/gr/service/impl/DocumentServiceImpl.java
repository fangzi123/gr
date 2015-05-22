package com.cyou.gr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyou.gr.dao.DocumentMapper;
import com.cyou.gr.entity.Document;
import com.cyou.gr.service.DocumentService;
@Service
@Transactional
public class DocumentServiceImpl implements DocumentService {
	@Autowired
	private DocumentMapper documentMapper;
	@Override
	public List<Document> selectDocList() {
		return documentMapper.selectDocList();
	}

}
