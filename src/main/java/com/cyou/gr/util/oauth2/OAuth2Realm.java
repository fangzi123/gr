package com.cyou.gr.util.oauth2;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthBearerClientRequest;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.OAuthAccessTokenResponse;
import org.apache.oltu.oauth2.client.response.OAuthResourceResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.message.types.GrantType;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.cyou.gr.entity.User;
import com.cyou.gr.service.UserService;
import com.cyou.gr.util.Constants;
import com.cyou.gr.util.JsonUtils;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-2-18
 * <p>Version: 1.0
 */
public class OAuth2Realm extends AuthorizingRealm {

    private String clientId;
    private String clientSecret;
    private String accessTokenUrl;
    private String userInfoUrl;
    private String redirectUrl;
    @Autowired
    private UserService userService;
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public void setAccessTokenUrl(String accessTokenUrl) {
        this.accessTokenUrl = accessTokenUrl;
    }

    public void setUserInfoUrl(String userInfoUrl) {
        this.userInfoUrl = userInfoUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof OAuth2Token;//表示此Realm只支持OAuth2Token类型
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        ShiroUser shiroUser = (ShiroUser) principals.fromRealm(getName()).iterator().next();
        try {
        	User u=userService.selectUserByName(shiroUser.getUsername());
        	authorizationInfo.addRole(Constants.ROLEZH.equals(u.getType())?Constants.ROLEEH:Constants.ROLEEH);
        	authorizationInfo.setStringPermissions(userService.selectPermissions(u.getId()));
		} catch (Exception e) {
			e.printStackTrace();
		}
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        OAuth2Token oAuth2Token = (OAuth2Token) token;
        String code = oAuth2Token.getAuthCode();
        ShiroUser shiroUser= extractUsername(code);

        SimpleAuthenticationInfo authenticationInfo =
                new SimpleAuthenticationInfo(shiroUser, code, getName());
        return authenticationInfo;
    }

    private ShiroUser extractUsername(String code) {

        try {
            OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());

            OAuthClientRequest accessTokenRequest = OAuthClientRequest
                    .tokenLocation(accessTokenUrl)
                    .setGrantType(GrantType.AUTHORIZATION_CODE)
                    .setClientId(clientId)
                    .setClientSecret(clientSecret)
                    .setCode(code)
                    .setRedirectURI(redirectUrl)
                    .buildBodyMessage();

            OAuthAccessTokenResponse oAuthResponse = oAuthClient.accessToken(accessTokenRequest, OAuth.HttpMethod.POST);

            String accessToken = oAuthResponse.getAccessToken();
            Long expiresIn = oAuthResponse.getExpiresIn();

            OAuthClientRequest userInfoRequest = new OAuthBearerClientRequest(userInfoUrl)
                    .setAccessToken(accessToken).buildQueryMessage();

            OAuthResourceResponse resourceResponse = oAuthClient.resource(userInfoRequest, OAuth.HttpMethod.GET, OAuthResourceResponse.class);
            String username = resourceResponse.getBody();
            ShiroUser shiroUser=JsonUtils.jsonString2Object(username, ShiroUser.class);
            return shiroUser;
        } catch (Exception e) {
            e.printStackTrace();
            throw new OAuth2AuthenticationException(e);
        }
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
		private String displayName;
		private String upn;
		private String mail;
		private String employeeID;
		private String department;
		private String title;
		

		public String getTitle() {
			return title;
		}


		public void setTitle(String title) {
			this.title = title;
		}


		public String getUsername() {
			return username;
		}


		public void setUsername(String username) {
			this.username = username;
		}


		public String getDisplayName() {
			return displayName;
		}


		public void setDisplayName(String displayName) {
			this.displayName = displayName;
		}


		public String getUpn() {
			return upn;
		}


		public void setUpn(String upn) {
			this.upn = upn;
		}


		public String getMail() {
			return mail;
		}


		public void setMail(String mail) {
			this.mail = mail;
		}


		public String getEmployeeID() {
			return employeeID;
		}


		public void setEmployeeID(String employeeID) {
			this.employeeID = employeeID;
		}


		public String getDepartment() {
			return department;
		}


		public void setDepartment(String department) {
			this.department = department;
		}


		@Override
		public String toString() {
			return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
		}

	}
}
