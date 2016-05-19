package com.cyou.gr.web.shiro;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.cyou.gr.entity.User;
import com.cyou.gr.service.UserService;
import com.cyou.gr.util.Constants;

/**
 * <p>
 * User: Zhang Kaitao
 * <p>
 * Date: 14-2-18
 * <p>
 * Version: 1.0
 */
public class ShiroDbRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		ShiroUser shiroUser = (ShiroUser) principals.fromRealm(getName())
				.iterator().next();
		try {
			User u = userService.selectUserByName(shiroUser.getUsername());
			authorizationInfo
					.addRole(Constants.ROLEZH.equals(u.getType()) ? Constants.ROLEEH
							: Constants.GUESTEH);
			authorizationInfo.setStringPermissions(userService
					.selectPermissions(u.getId()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		AuthenticationInfo authenticationInfo = null;
		ShiroUser shiroUser = new ShiroUser();
			User u = userService.selectUserByName(token.getPrincipal().toString());
			if(u!=null){
				shiroUser.setUsername(u.getName());
				shiroUser.setPassword(u.getPassword());
				authenticationInfo = new SimpleAuthenticationInfo(
						shiroUser, shiroUser.getPassword(), ByteSource.Util.bytes(u.getName()), getName());
			}
			return authenticationInfo;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息.
	 */
	public static class ShiroUser implements Serializable {

		private static final long serialVersionUID = 1L;

		private String username;
		private String password;

		@Override
		public String toString() {
			return ReflectionToStringBuilder.toString(this,
					ToStringStyle.MULTI_LINE_STYLE);
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

	}
}
