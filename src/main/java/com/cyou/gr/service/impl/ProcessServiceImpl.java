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
	@Override
	public void saveOrUpdateProcess(Process p) {
		if(p.getId()==null){//新增
			p.setSort(processMapper.selectMaxSort());
			p.setFlag(true);
			processMapper.insertSelective(p);
		}else{//修改
			processMapper.updateByPrimaryKeySelective(p);
		}		
	}
	@Override
	public void updownSort(Integer upSort, Integer upId, Integer downSort,
			Integer downId) {
		Process up=new Process();
		up.setId(upId);
		up.setSort(downSort);
		processMapper.updateByPrimaryKeySelective(up);
		Process down=new Process();
		down.setId(downId);
		down.setSort(upSort);
		processMapper.updateByPrimaryKeySelective(down);
	}

}
