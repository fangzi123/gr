package com.cyou.gr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.GitHubTokenResponse;
import org.apache.oltu.oauth2.client.response.OAuthAccessTokenResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.OAuthProviderType;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.types.GrantType;

/**
 * Simple example that shows how to get OAuth 2.0 access token from Facebook
 * using Amber OAuth 2.0 library
 *
 *
 *
 *
 */
public class OAuthClientTest {

    public static void main(String[] args) throws OAuthSystemException, IOException {

        try {
//            OAuthClientRequest request = OAuthClientRequest
//                .authorizationLocation("http://ldapproxy.cyou-inc.com/oauth/auth")
//                .setClientId("54d7293dce")
//                .setRedirectURI("http://localhost:8080/gr/index")
//                .setResponseType("code")
//                .buildQueryMessage();
           // dummyTest(request);
            //in web application you make redirection to uri:
//            System.out.println("Visit: " + request.getLocationUri() + "\nand grant permission");
//
//            System.out.print("Now enter the OAuth code you have received in redirect uri ");
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            String code = br.readLine();

        	OAuthClientRequest arequest = OAuthClientRequest
            	.tokenLocation("http://ldapproxy.cyou-inc.com/oauth/token")
                .setGrantType(GrantType.AUTHORIZATION_CODE)
                .setClientId("54d7293dce")
                .setClientSecret("026f94f27d")
                .setRedirectURI("http://localhost:8080/gr/index")
                .setCode("b82e34db3e21e4cf0eab3e27321458fcc8814cc3")
                .buildBodyMessage();
        	 OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());
        	 OAuthAccessTokenResponse oAuthResponse = oAuthClient.accessToken(arequest, OAuth.HttpMethod.POST);

             String accessToken = oAuthResponse.getAccessToken();

            System.out.println(
                "Access Token: " + oAuthResponse.getAccessToken() + ", Expires in: " + oAuthResponse
                    .getExpiresIn());
        } catch (OAuthProblemException e) {
            System.out.println("OAuth error: " + e.getError());
            System.out.println("OAuth error description: " + e.getDescription());
        }
    }

    public static void dummyTest(OAuthClientRequest request) throws HttpException, IOException {
        HttpClient httpClient = new HttpClient();
        // String url = "http://localhost:8080/rental/rent/entry.html";
        String url = "request";
        GetMethod getMethod = new GetMethod(request.getLocationUri());
        String charSet = "UTF-8";
        httpClient.getParams().setParameter(
                HttpMethodParams.HTTP_CONTENT_CHARSET, charSet);
        int statusCode = httpClient.executeMethod(getMethod);
        System.out.println(getMethod.getResponseBodyAsString());
    }
}
