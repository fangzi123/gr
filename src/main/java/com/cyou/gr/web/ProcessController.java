package com.cyou.gr.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cyou.gr.entity.Process;
import com.cyou.gr.service.ProcessService;
import com.cyou.gr.web.comm._BaseController;

@RequestMapping("/process")
@Controller
public class ProcessController extends _BaseController {

	@Autowired
	private ProcessService processService;
	@RequiresPermissions(value = { "process:list" })
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String home(HttpServletRequest request,
			HttpServletResponse response, Model model) throws Exception {
		List<Process> prosList = processService.selectProcessList(null);
		model.addAttribute("prosList", prosList);
		return "admin_process";
	}
	
	@RequiresPermissions(value = { "process:add" })
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(HttpServletRequest request,
			HttpServletResponse response, Model model,Process p) throws Exception {
		processService.saveOrUpdateProcess(p);
		return "redirect:/process/index";
	}
	
	@RequestMapping(value = "/delete")
	public String delete(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Integer id=this.findIntegerParameterValue(request, "id");
		Process obj=new Process();
		obj.setId(id);
		obj.setFlag(false);
		processService.saveOrUpdateProcess(obj);
		return "redirect:/process/index";
	}
	
	@RequestMapping(value = "/regain")
	public String regain(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Integer id=this.findIntegerParameterValue(request, "id");
		Process obj=new Process();
		obj.setId(id);
		obj.setFlag(true);
		processService.saveOrUpdateProcess(obj);
		return "redirect:/process/index";
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
		processService.updownSort(upSort,upId,downSort,downId);
        mm.addAttribute("success", true);
		return mm;
	}
}
