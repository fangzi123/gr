package com.cyou.gr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyou.gr.dao.CheckbillMapper;
import com.cyou.gr.dao.CheckbillTemplateMapper;
import com.cyou.gr.dao.FeeMapper;
import com.cyou.gr.dao.FeeTemplateMapper;
import com.cyou.gr.dao.ManpowerMapper;
import com.cyou.gr.dao.ManpowerTemplateMapper;
import com.cyou.gr.dao.ProcessNodeMapper;
import com.cyou.gr.dao.TaskBookMapper;
import com.cyou.gr.dao.TaskBookTemplateMapper;
import com.cyou.gr.entity.CheckbillTemplate;
import com.cyou.gr.entity.FeeTemplate;
import com.cyou.gr.entity.ManpowerTemplate;
import com.cyou.gr.entity.ProcessNode;
import com.cyou.gr.entity.TaskBookTemplate;
import com.cyou.gr.entity.vo.ProcessNodeVo;
import com.cyou.gr.service.ProcessNodeService;
import com.cyou.gr.util.Constants;
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
	@Autowired
	private FeeMapper feeMapper;
	@Autowired
	private ManpowerMapper manpowerMapper;
	@Autowired
	private TaskBookMapper taskBookMapper;
	@Autowired
	private CheckbillMapper checkbillMapper;
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
			obj.setHasManpower(false);
			obj.setHasTaskbook(false);
			obj.setHasCheckbill(false);
			obj.setHasDocument(false);
			processNodeMapper.insert(obj);
		}else{//修改
			processNodeMapper.updateByPrimaryKeySelective(obj);
			//添加费用模板
			if(obj.getHasFee()!=null&&obj.getHasFee()){
				for(Byte i=0;i<obj.getFeeName().length;i++){
					boolean isnew=false;
					if(obj.getFeetId()==null){
						isnew=true;
					}else{
						if(obj.getFeetId()[i]==null){
							isnew=true;
						}
					}
					FeeTemplate ft=new FeeTemplate();
					ft.setName(obj.getFeeName()[i]);
					ft.setSort(i);
					if(isnew){//新增
						ft.setProcessNodeId(obj.getId());
						ft.setFlag(true);
						feeTemplateMapper.insertSelective(ft);
					}else{//修改
						ft.setId(obj.getFeetId()[i]);
						feeTemplateMapper.updateByPrimaryKeySelective(ft);
					}
					
					
				}
			}
			//添加人力模板
			if(obj.getHasManpower()!=null&&obj.getHasManpower()){
				for(Byte i=0;i<obj.getProjectTeam().length;i++){
					boolean isnew=false;
					if(obj.getManpowertId()==null){//新增
						isnew=true;
					}else{//修改
						if(obj.getManpowertId()[i]==null){
							isnew=true;
						}
					}
					ManpowerTemplate mt=new ManpowerTemplate();
					mt.setSort(i);
					mt.setProjectTeam(obj.getProjectTeam()[i]);
					mt.setStandardModel(obj.getStandardModel()[i]);
					if(isnew){
						mt.setProcessNodeId(obj.getId());
						mt.setFlag(true);
						manpowerTemplateMapper.insertSelective(mt);
					}else{
						mt.setId(obj.getManpowertId()[i]);
						manpowerTemplateMapper.updateByPrimaryKeySelective(mt);
					}
				}
			}
			//添加任务书模板
			if(obj.getHasTaskbook()!=null&&obj.getHasTaskbook()){
				for(Byte i=0;i<obj.getQuotaName().length;i++){
					boolean isnew=false;
					if(obj.getTaskbooktId()==null){//新增
						isnew=true;
					}else{//修改
						if(obj.getTaskbooktId()[i]==null){
							isnew=true;
						}
					}
					TaskBookTemplate tt=new TaskBookTemplate();
					tt.setSort(i);
					tt.setQuotaName(obj.getQuotaName()[i]);
					tt.setQuotaType(obj.getQuotaType()[i]);
					if(isnew){
						tt.setProcessNodeId(obj.getId());
						tt.setFlag(true);
						taskBookTemplateMapper.insertSelective(tt);
					}else{
						tt.setId(obj.getTaskbooktId()[i]);
						taskBookTemplateMapper.updateByPrimaryKeySelective(tt);
					}
				}
			}
			//添加检查单模板
			if(obj.getHasCheckbill()!=null&&obj.getHasCheckbill()){
				for(Byte i=0;i<obj.getCheckItem().length;i++){
					boolean isnew=false;
					if(obj.getCheckbilltId()==null){//新增
						isnew=true;
					}else{//修改
						if(obj.getCheckbilltId()[i]==null){
							isnew=true;
						}
					}
					CheckbillTemplate ct=new CheckbillTemplate();
					ct.setSort(i);
					ct.setCheckItem(obj.getCheckItem()[i]);
					ct.setCheckItemProperty(obj.getCheckItemProperty()[i]);
					if(obj.getRemark().length>0){
						ct.setRemark(obj.getRemark()[i]);
					}
					if(isnew){
						ct.setProcessNodeId(obj.getId());
						ct.setFlag(true);
						checkbillTemplateMapper.insertSelective(ct);
					}else{
						ct.setId(obj.getCheckbilltId()[i]);
						checkbillTemplateMapper.updateByPrimaryKeySelective(ct);
					}
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

	@Override
	public void deleteWho(String who, Integer whoId,Boolean flag) {
		switch (who) {
		case Constants.FEETID:
			if(feeMapper.isUsed(whoId)==null){
				feeTemplateMapper.deleteByPrimaryKey(whoId);
			}else{
				FeeTemplate ft=new FeeTemplate();
				ft.setId(whoId);
				ft.setFlag(flag);
				feeTemplateMapper.updateByPrimaryKeySelective(ft);
			}
			break;
		case Constants.MANPOWERTID:
			if(manpowerMapper.isUsed(whoId)==null){
				manpowerTemplateMapper.deleteByPrimaryKey(whoId);
			}else{
				ManpowerTemplate mt=new ManpowerTemplate();
				mt.setId(whoId);
				mt.setFlag(flag);
				manpowerTemplateMapper.updateByPrimaryKeySelective(mt);
			}
			break;
		case Constants.TASKBOOKTID:
			if(taskBookMapper.isUsed(whoId)==null){
				taskBookTemplateMapper.deleteByPrimaryKey(whoId);
			}else{
				TaskBookTemplate tt=new TaskBookTemplate();
				tt.setId(whoId);
				tt.setFlag(flag);
				taskBookTemplateMapper.updateByPrimaryKeySelective(tt);
			}
			break;
		case Constants.CHECKBILLTID:
			if(checkbillMapper.isUsed(whoId)==null){
				checkbillTemplateMapper.deleteByPrimaryKey(whoId);
			}else{
				CheckbillTemplate ct=new CheckbillTemplate();
				ct.setId(whoId);
				ct.setFlag(flag);
				checkbillTemplateMapper.updateByPrimaryKeySelective(ct);
			}
			break;
		default:
			break;
		}
	}


}
