package com.cyou.gr.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyou.gr.dao.DocumentMapper;
import com.cyou.gr.entity.Document;
import com.cyou.gr.service.DocumentService;
import com.cyou.gr.util.ShiroHelper;
@Service
@Transactional
public class DocumentServiceImpl implements DocumentService {
	@Autowired
	private DocumentMapper documentMapper;
	@Override
	public List<Document> selectDocList() {
		return documentMapper.selectDocList();
	}
	@Override
	public void deleteDocById(Integer id) {
		documentMapper.deleteByPrimaryKey(id);
	}
	@Override
	public void saveOrUpdate(Document doc) {
		doc.setFlag(true);
		doc.setUploadTime(new Date());
		doc.setAuthor(ShiroHelper.getUsername());
		documentMapper.insertSelective(doc);
	}

}
