package com.cyou.gr.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cyou.gr.entity.Project;
import com.cyou.gr.entity.Process;
import com.cyou.gr.service.ProcessService;
import com.cyou.gr.service.ProjectService;
import com.cyou.gr.web.comm._BaseController;

@RequestMapping("/project")
@Controller
public class ProjectController extends _BaseController {

	@Autowired
	private ProjectService projectService;
	@Autowired
	private ProcessService processService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String home(HttpServletRequest request,
			HttpServletResponse response, Model model) throws Exception {
		List<Project> proList = projectService.selectProjectList(null);
		model.addAttribute("proList", proList);
		List<Process> processList = processService.selectProcessList(true);
		model.addAttribute("processList", processList);
		return "admin_project";
	}
	/**
	 * 添加项目的时候创建  项目节点
	 * @param request
	 * @param response
	 * @param model
	 * @param p
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(HttpServletRequest request,
			HttpServletResponse response, Model model,Project p) throws Exception {
		projectService.saveOrUpdateProject(p);
		return "redirect:/project/index";
	}
	
	@RequestMapping(value = "/delete")
	public String delete(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Integer id=this.findIntegerParameterValue(request, "id");
		Project obj=new Project();
		obj.setId(id);
		obj.setFlag(false);
		projectService.saveOrUpdateProject(obj);
		return "redirect:/project/index";
	}
	
	@RequestMapping(value = "/regain")
	public String regain(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Integer id=this.findIntegerParameterValue(request, "id");
		Project obj=new Project();
		obj.setId(id);
		obj.setFlag(true);
		projectService.saveOrUpdateProject(obj);
		return "redirect:/project/index";
	}
	
	@RequestMapping(value = "/sort", method = RequestMethod.POST)
	@ResponseBody
	public ModelMap sort(HttpServletRequest request,
			HttpServletResponse response) throws  Exception {
		ModelMap mm=new ModelMap();
		Integer upSort=this.findIntegerParameterValue(request, "upSort");
		Integer upId=this.findIntegerParameterValue(request, "upId");
		Integer downSort=this.findIntegerParameterValue(request, "downSort");
		Integer downId=this.findIntegerParameterValue(request, "downId");
		projectService.updownSort(upSort,upId,downSort,downId);
        mm.addAttribute("success", true);
		return mm;
	}
}
