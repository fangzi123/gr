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

import com.cyou.gr.entity.CheckbillTemplate;
import com.cyou.gr.entity.FeeTemplate;
import com.cyou.gr.entity.ManpowerTemplate;
import com.cyou.gr.entity.Process;
import com.cyou.gr.entity.ProcessNode;
import com.cyou.gr.entity.Quota;
import com.cyou.gr.entity.TaskBookTemplate;
import com.cyou.gr.entity.vo.ProcessNodeVo;
import com.cyou.gr.service.CheckbillTemplateService;
import com.cyou.gr.service.FeeTemplateService;
import com.cyou.gr.service.ManPowerTemplateService;
import com.cyou.gr.service.ProcessNodeService;
import com.cyou.gr.service.ProcessService;
import com.cyou.gr.service.QuotaService;
import com.cyou.gr.service.TaskBookTemplateService;
import com.cyou.gr.web.comm._BaseController;

@RequestMapping("/process/procNode")
@Controller
public class ProcessNodeController extends _BaseController {
	@Autowired
	private ProcessService processService;
	@Autowired
	private ProcessNodeService processNodeService;
	@Autowired
	private QuotaService quotaService;
	@Autowired
	private FeeTemplateService feeTemplateService;
	@Autowired
	private ManPowerTemplateService manPowerTemplateService;
	@Autowired
	private TaskBookTemplateService taskBookTemplateService;
	@Autowired
	private CheckbillTemplateService checkbillTemplateService;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String home(HttpServletRequest request,
			HttpServletResponse response, Model model) throws Exception {
		Integer procId=this.findIntegerParameterValue(request, "procId");
		Process process=processService.selectProcessById(procId);
		List<ProcessNode> procNodeList = processNodeService.selectProcNodeListByProcId(procId);
		model.addAttribute("procNodeList", procNodeList);
		model.addAttribute("process", process);
		return "admin_process_node";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(HttpServletRequest request,
			HttpServletResponse response, Model model,ProcessNodeVo obj) throws Exception {
		processNodeService.saveOrUpdateProcessNode(obj);
		model.addAttribute("procId", obj.getProcessId());
		return "redirect:/process/procNode/index";
	}
	
	@RequestMapping(value = "/modifyFlag")
	@ResponseBody
	public ModelMap modifyFlag(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelMap mm=new ModelMap();
		Integer id=this.findIntegerParameterValue(request, "id");
		Boolean flag=this.findBooleanParameterValue(request, "flag");
		ProcessNodeVo obj=new ProcessNodeVo();
		obj.setId(id);
		obj.setFlag(flag);
		processNodeService.saveOrUpdateProcessNode(obj);
		mm.addAttribute("success", true);
		return mm;
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
	
	/************************配置节点内容页面逻辑***start****************************/
	/**
	 * 节点内容查看页
	 * @param request
	 * @param response
	 * @param model
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String view(HttpServletRequest request,
			HttpServletResponse response, Model model,ProcessNodeVo obj) throws Exception {
		ProcessNode procNode=processNodeService.selectProcNodeById(obj.getId());
		model.addAttribute("procNode", procNode);
		List<Quota> quotaList=quotaService.selectQuotaListBy();
		model.addAttribute("quotaList", quotaList);
		if(procNode.getHasFee()){
			List<FeeTemplate> feets=feeTemplateService.selectFeeTemplatesByprocNodeId(obj.getId());
			model.addAttribute("feets", feets);
		}
		if(procNode.getHasManpower()){
			List<ManpowerTemplate> manpowerts=manPowerTemplateService.selectManpowerTemplatesByprocNodeId(obj.getId());
			model.addAttribute("manpowerts", manpowerts);
		}
		if(procNode.getHasTaskbook()){
			List<TaskBookTemplate> taskbookts=taskBookTemplateService.selectTaskbooktsByProcNodeId(obj.getId());
			model.addAttribute("taskbookts", taskbookts);
		}
		if(procNode.getHasCheckbill()){
			List<CheckbillTemplate> checkbillTs=checkbillTemplateService.selectCheckbillTsByProcNodeId(obj.getId());
			model.addAttribute("checkbillTs", checkbillTs);
		}
		return "admin_process_node_view";
	}
	/**
	 * 节点内容保存
	 * @param request
	 * @param response
	 * @param model
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/editSave", method = RequestMethod.POST)
	public String editSave(HttpServletRequest request,
			HttpServletResponse response, Model model,ProcessNodeVo obj) throws Exception {
		processNodeService.saveOrUpdateProcessNode(obj);
		model.addAttribute("procId", obj.getProcessId());
		return "redirect:/process/procNode/index";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ModelMap delete(HttpServletRequest request,
			HttpServletResponse response) throws  Exception {
		ModelMap mm=new ModelMap();
		String who=this.findStringParameterValue(request, "who");
		Integer whoId=this.findIntegerParameterValue(request, "whoId");
		Boolean flag=this.findBooleanParameterValue(request, "flag");
		processNodeService.deleteWho(who,whoId,flag);
        mm.addAttribute("success", true);
		return mm;
	}
	/************************配置节点内容页面逻辑***end******************************/
}
