package com.cyou.gr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cyou.gr.service.UserService;
import com.cyou.gr.web.comm._BaseController;


@Controller
public class HomeController extends _BaseController{
	
	@Autowired
	private UserService userService;

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		return "index";
	}
	
	//退出
//	@RequestMapping(value = "/logout", method = RequestMethod.GET)
//	public void logout(Model model) throws HttpException, IOException {
//		  HttpClient httpClient = new HttpClient();
//	        String url = "http://ldapproxy.cyou-inc.com/oauth/logout?client_id=54d7293dce&redirect_uri=http://10.12.20.14:8080/gr/index";
//	        GetMethod getMethod = new GetMethod(url);
//	        String charSet = "UTF-8";
//	        httpClient.getParams().setParameter(
//	                HttpMethodParams.HTTP_CONTENT_CHARSET, charSet);
//	        int statusCode = httpClient.executeMethod(getMethod);
//	}
	
}
