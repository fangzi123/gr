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

import com.cyou.gr.entity.ProcessNode;
import com.cyou.gr.service.ProcessNodeService;
import com.cyou.gr.web.comm._BaseController;

@RequestMapping("/process/procNode")
@Controller
public class ProcessNodeController extends _BaseController {

	@Autowired
	private ProcessNodeService processNodeService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String home(HttpServletRequest request,
			HttpServletResponse response, Model model) throws Exception {
		Integer procId=this.findIntegerParameterValue(request, "procId");
		List<ProcessNode> procNodeList = processNodeService.selectProcNodeListByProcId(procId);
		model.addAttribute("procNodeList", procNodeList);
		model.addAttribute("procId", procId);
		return "admin_process_node";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(HttpServletRequest request,
			HttpServletResponse response, Model model,ProcessNode obj) throws Exception {
		processNodeService.saveOrUpdateProcessNode(obj);
		model.addAttribute("procId", obj.getProcessId());
		return "redirect:/process/procNode/index";
	}
	
	@RequestMapping(value = "/delete")
	public String delete(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Integer id=this.findIntegerParameterValue(request, "id");
		ProcessNode obj=new ProcessNode();
		obj.setId(id);
		obj.setFlag(false);
		processNodeService.saveOrUpdateProcessNode(obj);
		return "redirect:/process/procNode/index";
	}
	
	@RequestMapping(value = "/regain")
	public String regain(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Integer id=this.findIntegerParameterValue(request, "id");
		ProcessNode obj=new ProcessNode();
		obj.setId(id);
		obj.setFlag(true);
		processNodeService.saveOrUpdateProcessNode(obj);
		return "redirect:/process/procNode/index";
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
		processNodeService.updownSort(upSort,upId,downSort,downId);
        mm.addAttribute("success", true);
		return mm;
	}
}
