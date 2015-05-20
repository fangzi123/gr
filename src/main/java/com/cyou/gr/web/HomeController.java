package com.cyou.gr.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cyou.gr.service.ProcessService;
import com.cyou.gr.entity.Process;
import com.cyou.gr.service.UserService;
import com.cyou.gr.web.comm._BaseController;


@Controller
public class HomeController extends _BaseController{
	
	@Autowired
	private UserService userService;
	@Autowired
	private ProcessService processService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		List<Process> procList=processService.selectProcessList(true);
		model.addAttribute("procList", procList);
		return "index";
	}
	
	//退出
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response) throws HttpException, IOException {
	        String url = "http://ldapproxy.cyou-inc.com/oauth/logout?client_id=54d7293dce&redirect_uri=http://10.12.20.14:8080/gr/index";
		    return "redirect:"+url;
	}
	
}
