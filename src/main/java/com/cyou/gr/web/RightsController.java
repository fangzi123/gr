package com.cyou.gr.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cyou.gr.entity.Project;
import com.cyou.gr.entity.vo.UserVo;
import com.cyou.gr.service.ProjectService;
import com.cyou.gr.service.UserService;
import com.cyou.gr.web.comm._BaseController;

@RequestMapping("/rights")
@Controller
public class RightsController extends _BaseController {

	@Autowired
	private UserService userService;
	@Autowired
	private ProjectService projectService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String home(HttpServletRequest request,
			HttpServletResponse response, Model model) throws Exception {
		List<UserVo> userList = userService.selectUserList();
		model.addAttribute("userList", userList);
		List<Project> proList = projectService.selectProjectList();
		model.addAttribute("proList", proList);
		return "admin_manage";
	}
	
	@RequestMapping(value = "/hasuser", method = RequestMethod.POST)
	@ResponseBody
	public ModelMap useradd(HttpServletRequest request,
			HttpServletResponse response) throws  Exception {
		ModelMap mm=new ModelMap();
		String username=this.findStringParameterValue(request, "username");
		HttpClient httpClient = new HttpClient();
        String url = "http://ldapproxy.cyou-inc.com/hasuser/"+username;
        GetMethod getMethod = new GetMethod(url);
        String charSet = "UTF-8";
        httpClient.getParams().setParameter(
                HttpMethodParams.HTTP_CONTENT_CHARSET, charSet);
        int statusCode = httpClient.executeMethod(getMethod);
        String  has=getMethod.getResponseBodyAsString();
        mm.addAttribute("hasuser", has);
		return mm;
	}

	@RequestMapping(value = "/useradd", method = RequestMethod.POST)
	public String useradd(HttpServletRequest request,
			HttpServletResponse response, Model model,UserVo uv) throws Exception {
		userService.saveOrUpdateUser(uv);
		return "redirect:/rights/index";
	}
}
