package com.cyou.gr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyou.gr.dao.ProcessMapper;
import com.cyou.gr.entity.Process;
import com.cyou.gr.service.ProcessService;
@Service
@Transactional
public class ProcessServiceImpl implements ProcessService {
	@Autowired
	private ProcessMapper processMapper;
	@Override
	public List<Process> selectProcessList() {
		return processMapper.selectProcessList();
	}

}
