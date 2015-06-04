package com.cyou.gr.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cyou.gr.entity.User;
import com.cyou.gr.web.comm._BaseController;

@Controller
public class LoginController extends _BaseController{
	/**
	 * 登录身份验证
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/login")
	public String authenticate(HttpServletRequest request,
			HttpServletResponse response,User u) throws Exception {

		Subject objCurrentUser = SecurityUtils.getSubject();

		log.debug("user principal: {}",
				new Object[] { objCurrentUser.getPrincipal() });
		log.debug("user authenticated: {}",
				new Object[] { objCurrentUser.isAuthenticated() });

		if (!objCurrentUser.isAuthenticated()) {
			UsernamePasswordToken objToken = new UsernamePasswordToken(
					u.getName(), u.getPassword(), true, null);
			try {
				objCurrentUser.login(objToken);
			} catch (Exception e) {
				log.error("不存在用户[{}]", new Object[] { objToken.getPrincipal() });
			} 

		}
		// 已通过身份验证
		return "redirect:/gr/index";
	}
	
	//退出
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response) throws HttpException, IOException {
		SecurityUtils.getSubject().logout();
		return "redirect:/";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("procList", 1);
		return "login";
	}
}
