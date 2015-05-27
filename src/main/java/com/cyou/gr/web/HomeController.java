package com.cyou.gr.web;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cyou.gr.service.ProcessService;
import com.cyou.gr.service.ProjectNodeService;
import com.cyou.gr.service.ProjectService;
import com.cyou.gr.entity.ProNode;
import com.cyou.gr.entity.Process;
import com.cyou.gr.entity.vo.ProjectVo;
import com.cyou.gr.service.UserService;
import com.cyou.gr.web.comm._BaseController;


@Controller
public class HomeController extends _BaseController{
	
	@Autowired
	private UserService userService;
	@Autowired
	private ProcessService processService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private ProjectNodeService projectNodeService;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		List<Process> procList=processService.selectProcessRelatedList();
		model.addAttribute("procList", procList);
		return "index";
	}
	
	//退出
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response) throws HttpException, IOException {
	        String url = "http://ldapproxy.cyou-inc.com/oauth/logout?client_id=54d7293dce&redirect_uri=http://10.12.20.14:8080/gr/index";
		    return "redirect:"+url;
	}
	
	/********************评审进度模块***************************/
	/**
	 * 项目查看
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/gr/projview")
	public String projview(HttpServletRequest request,
			HttpServletResponse response,Model model) throws Exception {
		Integer id=this.findIntegerParameterValue(request, "id");
		ProjectVo project = projectService.selectProjectRelatedById(id);
		Set<Object> pcTypeSet=new HashSet<Object>();
		for(ProNode pn:project.getProjNodeList()){
			pcTypeSet.add(pn.getProcessNode().getProcessType());
		}
		model.addAttribute("project", project);
		model.addAttribute("pcTypeSet", pcTypeSet);
		return "project";
	}
	
	@RequestMapping(value = "/gr/projnview")
	public String projnview(HttpServletRequest request,
			HttpServletResponse response,Model model) throws Exception {
		Integer id=this.findIntegerParameterValue(request, "id");
		ProNode projNode = projectNodeService.selectProjectNodeRelatedById(id);
		model.addAttribute("projNode", projNode);
		return "porject_edit";
	}
	
}
