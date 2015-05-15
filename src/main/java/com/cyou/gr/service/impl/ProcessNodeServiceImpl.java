package com.cyou.gr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyou.gr.dao.ProcessNodeMapper;
import com.cyou.gr.entity.ProcessNode;
import com.cyou.gr.service.ProcessNodeService;
@Service
@Transactional
public class ProcessNodeServiceImpl implements ProcessNodeService {
	@Autowired
	private ProcessNodeMapper processNodeMapper;
	@Override
	public List<ProcessNode> selectProcNodeListByProcId(Integer procId) {
		return processNodeMapper.selectProcNodeListByProcId(procId);
	}
	
	@Override
	public void saveOrUpdateProcessNode(ProcessNode obj) {
		if(obj.getId()==null){//新增
			obj.setSort(processNodeMapper.selectMaxSort());
			obj.setFlag(true);
			processNodeMapper.insertSelective(obj);
		}else{//修改
			processNodeMapper.updateByPrimaryKeySelective(obj);
		}		
	}

	@Override
	public void updownSort(Integer upSort, Integer upId, Integer downSort,
			Integer downId) {
		ProcessNode up=new ProcessNode();
		up.setId(upId);
		up.setSort(downSort);
		processNodeMapper.updateByPrimaryKeySelective(up);
		ProcessNode down=new ProcessNode();
		down.setId(downId);
		down.setSort(upSort);
		processNodeMapper.updateByPrimaryKeySelective(down);
	}

	@Override
	public ProcessNode selectProcNodeById(Integer id) {
		return processNodeMapper.selectByPrimaryKey(id);
	}


}
