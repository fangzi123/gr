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

import com.cyou.gr.entity.Document;
import com.cyou.gr.entity.ProNode;
import com.cyou.gr.entity.Project;
import com.cyou.gr.service.DocumentService;
import com.cyou.gr.service.ProjectNodeService;
import com.cyou.gr.service.ProjectService;
import com.cyou.gr.web.comm._BaseController;

@RequestMapping("/doc")
@Controller
public class DocumentController extends _BaseController{
	
	@Autowired
	private DocumentService documentService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private ProjectNodeService projectNodeService;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String home(Model model) {
		List<Document> docList=documentService.selectDocList();
		model.addAttribute("docList", docList);
		List<Project> projList=projectService.selectProjectList(true);
		model.addAttribute("projList", projList);
		return "files";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(HttpServletRequest request,
			HttpServletResponse response, Model model) throws Exception {
		return "redirect:/doc/index";
	}
	
	@RequestMapping(value = "/projNodeList", method = RequestMethod.POST)
	@ResponseBody
	public ModelMap projNodeList(HttpServletRequest request,
			HttpServletResponse response) throws  Exception {
		ModelMap mm=new ModelMap();
		Integer projectId=this.findIntegerParameterValue(request, "projectId");
		ProNode proNode=projectNodeService.selectProjNodeList(projectId);
        mm.addAttribute("proNode", proNode);
		return mm;
	}
}
