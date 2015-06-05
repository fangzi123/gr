package com.cyou.gr.util;

import org.apache.shiro.SecurityUtils;

import com.cyou.gr.web.shiro.ShiroDbRealm.ShiroUser;





/**
 * @Description shiro框架帮助类
 * @author 
 * @date 2013-3-21
 * @version 1.0
 */
public class ShiroHelper {
	
	/**
	 * @Description 获取当前登录用户名称
	 * @return
	 * @author 
	 */
	public static String getUsername(){
		ShiroUser su = getShiroUser();
		return su == null ? null : su.getUsername();
	}
	
	public static ShiroUser getShiroUser() {
		return ShiroUser.class.cast(SecurityUtils.getSubject().getPrincipal());
	}
	
	public static boolean isAuth(){
		return SecurityUtils.getSubject().isAuthenticated();
	}
}
