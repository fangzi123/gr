package com.cyou.gr.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cyou.gr.entity.ProNode;
import com.cyou.gr.entity.vo.CalendarVo;
import com.cyou.gr.service.ProjectNodeService;
import com.cyou.gr.util.DateUtil;
import com.cyou.gr.util.JsonUtils;
import com.cyou.gr.web.comm._BaseController;

@RequestMapping("/calendar")
@Controller
public class CalendarController extends _BaseController{
	@Autowired
	private ProjectNodeService projectNodeService;
	private String URL="%s/gr/projview?id=%s&pjnid=%s";
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String home(HttpServletRequest request, HttpServletResponse response,Model model) {
		List<ProNode> pjnList= projectNodeService.selectPjnListForCalendar();
		List<CalendarVo> list=new ArrayList<CalendarVo>();
		for(ProNode pjn:pjnList){
			String title=pjn.getProject().getName()+":"+pjn.getProcessNode().getName();
			Object url[]={request.getContextPath(),pjn.getProjectId(),pjn.getId()};
			CalendarVo vo=new CalendarVo();
			vo.setTitle(title);
			vo.setUrl(String.format(URL, url));
			if("时间段".equals(pjn.getProcessNode().getTimeType())){
					vo.setStart(DateUtil.getDateStr(pjn.getStartTime(), "yyyy-MM-dd"));
					vo.setEnd(DateUtil.getDateStr(DateUtil.dataPlusInterval(pjn.getEndTime(), 1), "yyyy-MM-dd"));
			}else{
					vo.setStart(DateUtil.getDateStr(pjn.getReviewTime(), "yyyy-MM-dd"));
					vo.setEnd("null");
			}
			list.add(vo);
		}
		model.addAttribute("list", JsonUtils.list2JsonString(list));
		return "calendar";
	}
	
}
