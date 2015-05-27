package com.cyou.gr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyou.gr.dao.FeeMapper;
import com.cyou.gr.dao.ManpowerMapper;
import com.cyou.gr.dao.ProNodeMapper;
import com.cyou.gr.dao.TaskBookMapper;
import com.cyou.gr.entity.Fee;
import com.cyou.gr.entity.Manpower;
import com.cyou.gr.entity.ProNode;
import com.cyou.gr.entity.TaskBook;
import com.cyou.gr.entity.vo.ProNodeVo;
import com.cyou.gr.service.ProjectNodeService;
import com.cyou.gr.util.DateUtil;
@Transactional
@Service
public class ProjectNodeServiceImpl implements ProjectNodeService {
	@Autowired
	private ProNodeMapper proNodeMapper;
	@Autowired
	private FeeMapper feeMapper;
	@Autowired
	private ManpowerMapper manpowerMapper;
	@Autowired
	private TaskBookMapper taskBookMapper;

	@Override
	public List<ProNode> selectProjNodeList(Integer projectId) {
		return proNodeMapper.selectProjNodeList(projectId);
	}

	@Override
	public ProNode selectProjectNodeRelatedById(Integer id) {
		return proNodeMapper.selectProjectNodeRelatedById(id);
	}

	@Override
	public void updateProjectNode(ProNodeVo vo) {
		ProNode pjn=new ProNode();
		pjn.setId(vo.getId());
		pjn.setStatus(vo.getStatus());
		pjn.setStartTime(DateUtil.getDate(vo.getStartTime(), "yyyy-MM-dd"));
		pjn.setEndTime(DateUtil.getDate(vo.getEndTime(), "yyyy-MM-dd"));
		pjn.setIsNormal(vo.getIsNormal());
		pjn.setCurrentProgressDesc(vo.getCurrentProgressDesc());
		proNodeMapper.updateByPrimaryKeySelective(pjn);
		
		for(int i=0;i<vo.getFeeId().length;i++){
			Fee fee=new Fee();
			fee.setId(vo.getFeeId()[i]);
			fee.setDisplay(vo.getDisplay()[i]);
			fee.setMoney(vo.getMoney()[i]);
			feeMapper.updateByPrimaryKeySelective(fee); 
		}
		
		for(int i=0;i<vo.getManpowerId().length;i++){
			Manpower man=new Manpower();
			man.setId(vo.getManpowerId()[i]);
			man.setCoreMan(vo.getCoreMan()[i]);
			manpowerMapper.updateByPrimaryKeySelective(man);
		}
		
		for(int i=0;i<vo.getTaskbookId().length;i++){
			TaskBook tb=new TaskBook();
			tb.setId(vo.getTaskbookId()[i]);
			tb.setQuotaNum(vo.getQuotaNum()[i]);
			tb.setQuotaNumReal(vo.getQuotaNumReal()[i]);
			taskBookMapper.updateByPrimaryKeySelective(tb);
		}
	}

}
