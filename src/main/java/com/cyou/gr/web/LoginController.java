package com.cyou.gr.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cyou.gr.util.ShiroHelper;
import com.cyou.gr.web.comm._BaseController;

@Controller
public class LoginController extends _BaseController{
	
	@RequestMapping(value = "/")
	public String home(HttpServletRequest req, Model model) {
		   if(!ShiroHelper.isAuth()){
			   String exceptionClassName = (String)req.getAttribute("shiroLoginFailure");
			   String error = null;
			   if(UnknownAccountException.class.getName().equals(exceptionClassName)) {
				   error = "用户名/密码错误";
			   } else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
				   error = "用户名/密码错误";
			   } else if(ExcessiveAttemptsException.class.getName().equals(exceptionClassName)) {
				   error = "连续五次密码输入错误，锁定一小时";
			   }else if(exceptionClassName != null) {
				   error = "其他错误：" + exceptionClassName;
			   }
			   model.addAttribute("error", error);
			   return "login";
		   }else{
			   return "redirect:/gr/index";
		   }
	}
}
