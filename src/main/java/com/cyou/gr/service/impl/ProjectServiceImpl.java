package com.cyou.gr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyou.gr.dao.CheckbillMapper;
import com.cyou.gr.dao.FeeMapper;
import com.cyou.gr.dao.ManpowerMapper;
import com.cyou.gr.dao.ProNodeMapper;
import com.cyou.gr.dao.ProcessNodeMapper;
import com.cyou.gr.dao.ProjectMapper;
import com.cyou.gr.dao.TaskBookMapper;
import com.cyou.gr.entity.Checkbill;
import com.cyou.gr.entity.CheckbillTemplate;
import com.cyou.gr.entity.Fee;
import com.cyou.gr.entity.FeeTemplate;
import com.cyou.gr.entity.Manpower;
import com.cyou.gr.entity.ManpowerTemplate;
import com.cyou.gr.entity.ProNode;
import com.cyou.gr.entity.ProcessNode;
import com.cyou.gr.entity.Project;
import com.cyou.gr.entity.TaskBook;
import com.cyou.gr.entity.TaskBookTemplate;
import com.cyou.gr.entity.vo.ProjectVo;
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
	@Autowired
	private FeeMapper feeMapper;
	@Autowired
	private ManpowerMapper manpowerMapper;
	@Autowired
	private TaskBookMapper taskBookMapper;
	@Autowired
	private CheckbillMapper checkbillMapper;

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
			this.addDefaultProjNode(p);
		}else{//修改
			projectMapper.updateByPrimaryKeySelective(p);
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

	@Override
	public ProjectVo selectProjectRelatedById(Integer id) {
		return projectMapper.selectProjectRelatedById(id);
	}
	
	public void addDefaultProjNode(Project p) {
		List<ProcessNode>  procnList=processNodeMapper.selectProcNodeListByProcId(p.getProcessId());
		for(ProcessNode procn:procnList){
			ProNode projn=new ProNode();
			projn.setProjectId(p.getId());
			projn.setProcessNodeId(procn.getId());
			projn.setStatus("未开启");
			projn.setIsNormal("正常");
			proNodeMapper.insertSelective(projn);
			
			if(procn.getHasFee()){
				List<FeeTemplate> ftList=procn.getFeetList();
				Fee fee=new Fee();
				fee.setProNodeId(projn.getId());
				fee.setDisplay(false);
				for(int i=0;i<ftList.size();i++){
					fee.setFeeTemplateId(ftList.get(i).getId());
					feeMapper.insertSelective(fee);
				}
			}
			if(procn.getHasManpower()){
				List<ManpowerTemplate> mantList=procn.getMantList();
				Manpower man=new Manpower();
				man.setProNodeId(projn.getId());
				for(int i=0;i<mantList.size();i++){
					man.setManpowerTemplateId(mantList.get(i).getId());
					manpowerMapper.insertSelective(man);
				}
			}
			if(procn.getHasTaskbook()){
				List<TaskBookTemplate> tbtList=procn.getTbtList();
				TaskBook tb=new TaskBook();
				tb.setProNodeId(projn.getId());
				for(int i=0;i<tbtList.size();i++){
					tb.setTaskBookTemplateId(tbtList.get(i).getId());
					taskBookMapper.insertSelective(tb);
				}
			}
			if(procn.getHasCheckbill()){
				List<CheckbillTemplate> cbtList=procn.getCbtList();
				Checkbill cb=new Checkbill();
				cb.setProNodeId(projn.getId());
				for(int i=0;i<cbtList.size();i++){
					cb.setCheckbillTemplateId(cbtList.get(i).getId());
					checkbillMapper.insertSelective(cb);
				}
			}
		}
	}

	@Override
	public List<Project> selectProjListByProcId(Integer processId) {
		return projectMapper.selectProjListByProcId(processId);
	}

}
