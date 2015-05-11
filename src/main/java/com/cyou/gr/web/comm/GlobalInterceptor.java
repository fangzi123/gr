package com.cyou.gr.web.comm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cyou.gr.entity.User;
import com.cyou.gr.service.UserService;
import com.cyou.gr.util.oauth2.OAuth2Realm.ShiroUser;

public class GlobalInterceptor extends HandlerInterceptorAdapter {

	protected transient Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserService userService;

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		Subject subject = SecurityUtils.getSubject();
		if (subject != null && subject.isAuthenticated()) {
			ShiroUser sUser = (ShiroUser) subject.getPrincipal();
			User u = userService.selectUserByName(sUser.getUsername());
			if (u == null) {
				request.getRequestDispatcher("/refuse.jsp").forward(request,
						response);
				return false;
			}
		}
		return true;
	}
}
