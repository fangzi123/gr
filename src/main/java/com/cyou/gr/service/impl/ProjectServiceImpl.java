package com.cyou.gr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyou.gr.dao.ProNodeMapper;
import com.cyou.gr.dao.ProcessNodeMapper;
import com.cyou.gr.dao.ProjectMapper;
import com.cyou.gr.entity.ProNode;
import com.cyou.gr.entity.ProcessNode;
import com.cyou.gr.entity.Project;
import com.cyou.gr.service.ProjectService;

@Transactional
@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectMapper projectMapper;
	@Autowired
	private ProcessNodeMapper processNodeMapper;
	@Autowired
	private ProNodeMapper proNodeMapper;

	@Override
	public List<Project> selectProjectList(Boolean flag){
		List<Project> proList=projectMapper.selectProList(flag);
		return proList;
	}

	@Override
	public void saveOrUpdateProject(Project p) {
		if(p.getId()==null){//新增
			p.setSort(projectMapper.selectMaxSort());
			p.setFlag(true);
			projectMapper.insertSelective(p);
			
			List<ProcessNode>  procnList=processNodeMapper.selectProcNodeListByProcId(p.getProcessId());
			for(ProcessNode procn:procnList){
				ProNode projn=new ProNode();
				projn.setProjectId(p.getId());
				projn.setProcessNodeId(procn.getId());
				projn.setStatus("未开启");
				projn.setIsNormal("正常");
				proNodeMapper.insertSelective(projn);
			}
			
		}else{//修改
			projectMapper.updateByPrimaryKeySelective(p);
			List<ProcessNode>  procnList=processNodeMapper.selectProcNodeListByProcId(p.getProcessId());
			for(ProcessNode procn:procnList){
				ProNode projn=new ProNode();
				projn.setProjectId(p.getId());
				projn.setProcessNodeId(procn.getId());
				projn.setStatus("未开启");
				projn.setIsNormal("正常");
				proNodeMapper.insertSelective(projn);
			}
		}
	}

	@Override
	public void updownSort(Integer upSort, Integer upId, Integer downSort,
			Integer downId) {
		Project up=new Project();
		up.setId(upId);
		up.setSort(downSort);
		projectMapper.updateByPrimaryKeySelective(up);
		Project down=new Project();
		down.setId(downId);
		down.setSort(upSort);
		projectMapper.updateByPrimaryKeySelective(down);
	}

}
