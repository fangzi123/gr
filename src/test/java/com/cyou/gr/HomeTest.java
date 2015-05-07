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

}
