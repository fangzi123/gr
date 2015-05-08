package com.cyou.gr;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;

import com.cyou.gr.comm.AbstractSpringContextTestSupport;
import com.cyou.gr.entity.User;
import com.cyou.gr.service.UserManageService;
@WebAppConfiguration
public class HomeTest extends AbstractSpringContextTestSupport{
	@Autowired
	private UserManageService userManageService;

    @Test
    public void fatherId() throws Exception {
    	User e=new User();
		e.setId(1);
		e.setName("测试成功1");
		userManageService.updateEmp(e);
    }

//    @Test
//    public void findCoverProject() throws Exception {
//        HttpClient httpClient = new HttpClient();
//        // String url = "http://localhost:8080/rental/rent/entry.html";
//        String url = "http://localhost:8080/rental/pay/unify";
//        PostMethod postMethod = new PostMethod(url);
//        String charSet = "UTF-8";
//        httpClient.getParams().setParameter(
//                HttpMethodParams.HTTP_CONTENT_CHARSET, charSet);
//        String a = "<xml><a>1</a><return_code>SUCCESS</return_code><return_msg></return_msg><appid>wx8276ac869116d5aa</appid><mch_id>10058488</mch_id><nonce_str></nonce_str><sign></sign><result_code>SUCCESS</result_code><err_code></err_code><err_code_des></err_code_des><openid>o00MJjxDIObA_dpqLSnnewODPVx8</openid><is_subscribe>N</is_subscribe><trade_type>JSAPI</trade_type><bank_type>bankType</bank_type><total_fee>1000</total_fee><coupon_fee></coupon_fee><fee_type></fee_type><transaction_id>12345678901234567890123456789012</transaction_id><out_trade_no>test7764262942</out_trade_no><time_end>20141231100001</time_end></xml>";
//        postMethod.setRequestBody(a);
//        int statusCode = httpClient.executeMethod(postMethod);
//        System.out.println(postMethod.getResponseBodyAsString());
//    }
}
