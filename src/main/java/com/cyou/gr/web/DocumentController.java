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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cyou.gr.entity.Document;
import com.cyou.gr.entity.ProNode;
import com.cyou.gr.entity.Project;
import com.cyou.gr.service.DocumentService;
import com.cyou.gr.service.ProjectNodeService;
import com.cyou.gr.service.ProjectService;
import com.cyou.gr.service.UploadService;
import com.cyou.gr.util.FileUtils;
import com.cyou.gr.util.JsonUtils;
import com.cyou.gr.web.comm._BaseController;

@RequestMapping("/doc")
@Controller
public class DocumentController extends _BaseController {

	@Autowired
	private DocumentService documentService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private ProjectNodeService projectNodeService;
	@Autowired
	private UploadService uploadService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String home(Model model) {
		List<Document> docList = documentService.selectDocList();
		model.addAttribute("docList", docList);
		List<Project> projList = projectService.selectProjectList(true);
		model.addAttribute("projList", projList);
		return "files";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(HttpServletRequest request, HttpServletResponse response,
			Model model) throws Exception {
		return "redirect:/doc/index";
	}

	@RequestMapping(value = "/projNodeList", method = RequestMethod.POST)
	@ResponseBody
	public ModelMap projNodeList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelMap mm = new ModelMap();
		Integer projectId = this
				.findIntegerParameterValue(request, "projectId");
		List<ProNode> proNodeList = projectNodeService
				.selectProjNodeList(projectId);
		mm.addAttribute("proNodeList", proNodeList);
		return mm;
	}

	@RequestMapping(value = "/download")
	public void download(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String path = this.findStringParameterValue(request, "path");
		FileUtils.download(path, response);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ModelMap detele(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelMap mm = new ModelMap();
		Integer id = this.findIntegerParameterValue(request, "id");
		documentService.deleteDocById(id);
		mm.addAttribute("success", true);
		return mm;
	}

//	@RequestMapping(value = "/upload", method = RequestMethod.POST)
//	public  String  upload(HttpServletRequest request,
//			HttpServletResponse response,
//			@RequestParam(value = "doc", required = false) MultipartFile file)
//			throws Exception {
//		String filePath = "";
//		if (file.getSize() == 0){
//		}else{
//			filePath = uploadService.doUpload(file, null);
//		}
//		Integer id = this.findIntegerParameterValue(request, "id");
//		Integer projectId = this.findIntegerParameterValue(request, "projectId");
//		Document doc=new Document();
//		doc.setFilename(file.getOriginalFilename());
//		doc.setUrl(filePath);
//		doc.setProNodeId(id);
//		doc.setProjectId(projectId);
//		documentService.saveOrUpdate(doc);
//		return "redirect:/gr/projnview?id="+id;
//	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public void upload(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value = "doc", required = false) MultipartFile file) throws Exception {
		ModelMap mm = new ModelMap();
		String filePath = "";
		if (file.getSize() == 0){
		}else{
			filePath = uploadService.doUpload(file, null);
		}
		Integer id = this.findIntegerParameterValue(request, "id");
		Integer projectId = this.findIntegerParameterValue(request, "projectId");
		Document doc=new Document();
		doc.setFilename(file.getOriginalFilename());
		doc.setUrl(filePath);
		doc.setProNodeId(id);
		doc.setProjectId(projectId);
		documentService.saveOrUpdate(doc);
		mm.addAttribute("success", true);
		this.returnJson(response, JsonUtils.map2JsonString(mm));
	}
}
