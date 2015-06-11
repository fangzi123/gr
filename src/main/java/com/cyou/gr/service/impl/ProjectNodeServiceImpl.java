package com.cyou.gr.service.impl;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyou.gr.dao.CheckbillMapper;
import com.cyou.gr.dao.FeeMapper;
import com.cyou.gr.dao.ManpowerMapper;
import com.cyou.gr.dao.ProNodeMapper;
import com.cyou.gr.dao.TaskBookMapper;
import com.cyou.gr.entity.Checkbill;
import com.cyou.gr.entity.Fee;
import com.cyou.gr.entity.Manpower;
import com.cyou.gr.entity.ProNode;
import com.cyou.gr.entity.TaskBook;
import com.cyou.gr.entity.vo.ProNodeVo;
import com.cyou.gr.service.ProjectNodeService;
import com.cyou.gr.util.ConfigUtil;
import com.cyou.gr.util.DateUtil;
import com.cyou.gr.util.EmailUtil;
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
	@Autowired
	private CheckbillMapper checkbillMapper;

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
		pjn.setReviewTime(DateUtil.getDate(vo.getReviewTime(),"yyyy-MM-dd"));
		pjn.setIsNormal(vo.getIsNormal());
		pjn.setCurrentProgressDesc(vo.getCurrentProgressDesc());
		proNodeMapper.updateByPrimaryKeySelective(pjn);
		if(vo.getFeeId()!=null){
			for(int i=0;i<vo.getFeeId().length;i++){
				Fee fee=new Fee();
				fee.setId(vo.getFeeId()[i]);
				fee.setDisplay(vo.getDisplay()[i]);
				fee.setMoney(vo.getMoney()[i]);
				feeMapper.updateByPrimaryKeySelective(fee); 
			}		
		}
		if(vo.getManpowerId()!=null){
		for(int i=0;i<vo.getManpowerId().length;i++){
			Manpower man=new Manpower();
			man.setId(vo.getManpowerId()[i]);
			man.setCoreMan(vo.getCoreMan()[i]);
			manpowerMapper.updateByPrimaryKeySelective(man);
		}}
		if(vo.getTaskbookId()!=null){
		for(int i=0;i<vo.getTaskbookId().length;i++){
			TaskBook tb=new TaskBook();
			tb.setId(vo.getTaskbookId()[i]);
			tb.setQuotaNum(vo.getQuotaNum()[i]);
			tb.setQuotaNumReal(vo.getQuotaNumReal()[i]);
			taskBookMapper.updateByPrimaryKeySelective(tb);
		}}
		if(vo.getCheckbillId()!=null){
		for(int i=0;i<vo.getCheckbillId().length;i++){
			Checkbill cb=new Checkbill();
			cb.setId(vo.getCheckbillId()[i]);
			cb.setCheckItem(vo.getCheckItem()[i]);
			cb.setRemark(vo.getRemark()[i]);
			cb.setIsqualified(vo.getIsqualified()[i]);
			checkbillMapper.updateByPrimaryKeySelective(cb);
		}}
	}

	public boolean sendEmailToPersonService(Map<String, Object> map) throws Exception {
		String subject;
		String message;
		String[] emails = { (String) map.get("to") };
		try {
			ProNode pjn=new ProNode();
			pjn.setId((Integer) map.get("id"));
			pjn.setStatus("已完成");
			proNodeMapper.updateByPrimaryKeySelective(pjn);
			//发送邮件
			subject = ConfigUtil.getConfig("mail.template.employee.subject");
			message = ConfigUtil.getConfig("mail.template.employee.message");
			EmailUtil.sendHtmlEmail(
					MessageFormat.format(subject, map.get("title")),
					MessageFormat.format(message, map.get("contents")),
					emails);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public List<ProNode> selectPjnListForCalendar() {
		return proNodeMapper.selectPjnListForCalendar();
	}
}
