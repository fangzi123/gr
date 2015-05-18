package com.cyou.gr.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyou.gr.dao.CheckbillTemplateMapper;
import com.cyou.gr.dao.FeeTemplateMapper;
import com.cyou.gr.dao.ManpowerTemplateMapper;
import com.cyou.gr.dao.ProcessNodeMapper;
import com.cyou.gr.dao.TaskBookTemplateMapper;
import com.cyou.gr.entity.CheckbillTemplate;
import com.cyou.gr.entity.FeeTemplate;
import com.cyou.gr.entity.ManpowerTemplate;
import com.cyou.gr.entity.ProcessNode;
import com.cyou.gr.entity.TaskBookTemplate;
import com.cyou.gr.entity.vo.ProcessNodeVo;
import com.cyou.gr.service.ProcessNodeService;
@Service
@Transactional
public class ProcessNodeServiceImpl implements ProcessNodeService {
	@Autowired
	private ProcessNodeMapper processNodeMapper;
	@Autowired
	private FeeTemplateMapper feeTemplateMapper;
	@Autowired
	private ManpowerTemplateMapper manpowerTemplateMapper;
	@Autowired
	private TaskBookTemplateMapper taskBookTemplateMapper;
	@Autowired
	private CheckbillTemplateMapper checkbillTemplateMapper;
	@Override
	public List<ProcessNode> selectProcNodeListByProcId(Integer procId) {
		return processNodeMapper.selectProcNodeListByProcId(procId);
	}
	
	@Override
	public void saveOrUpdateProcessNode(ProcessNodeVo obj) {
		if(obj.getId()==null){//新增
			obj.setSort(processNodeMapper.selectMaxSort());
			obj.setFlag(true);
			obj.setHasFee(false);
			obj.setHasManPower(false);
			obj.setHasTaskBook(false);
			obj.setHasCheckBill(false);
			obj.setHasDocument(false);
			processNodeMapper.insert(obj);
		}else{//修改
			processNodeMapper.updateByPrimaryKeySelective(obj);
			//添加费用模板
			if(obj.getFeeName().length>0){
				for(Byte i=0;i<obj.getFeeName().length;i++){
					if(obj.getFeetId()==null){
						
					}
					FeeTemplate ft=new FeeTemplate();
					ft.setProcessNodeId(obj.getId());
					ft.setName(obj.getFeeName()[i]);
					ft.setSort(i);
					feeTemplateMapper.insertSelective(ft);
				}
			}
			//添加人力模板
			if(obj.getProjectTeam().length>0&&obj.getStandardModel().length>0){
				for(Byte i=0;i<obj.getProjectTeam().length;i++){
					ManpowerTemplate mt=new ManpowerTemplate();
					mt.setProcessNodeId(obj.getId());
					mt.setSort(i);
					mt.setProjectTeam(obj.getProjectTeam()[i]);
					mt.setStandardModel(obj.getStandardModel()[i]);
					manpowerTemplateMapper.insertSelective(mt);
				}
			}
			//添加任务书模板
			if(obj.getHasTaskBook()){
				for(Byte i=0;i<obj.getQuotaName().length;i++){
					TaskBookTemplate tt=new TaskBookTemplate();
					tt.setProcessNodeId(obj.getId());
					tt.setSort(i);
					tt.setQuotaName(obj.getQuotaName()[i]);
					tt.setQutaType(obj.getQuotaType()[i]);
					taskBookTemplateMapper.insertSelective(tt);
				}
			}
			//添加检查单模板
			if(obj.getCheckItem().length>0){
				for(Byte i=0;i<obj.getCheckItem().length;i++){
					CheckbillTemplate ct=new CheckbillTemplate();
					ct.setProcessNodeId(obj.getId());
					ct.setSort(i);
					ct.setCheckItem(obj.getCheckItem()[i]);
					ct.setCheckItemProperty(obj.getCheckItemProperty()[i]);
					ct.setRemark(obj.getRemark()[i]);
					checkbillTemplateMapper.insertSelective(ct);
				}
			}
			
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
