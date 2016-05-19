package com.cyou.gr.util;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cyou.gr.entity.User;
import com.cyou.gr.entity.vo.UserVo;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
@Service
public class PasswordHelper {

    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    @Value("${password.algorithmName}")
    private String algorithmName = "md5";
    @Value("${password.hashIterations}")
    private int hashIterations = 2;

    public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public void setHashIterations(int hashIterations) {
        this.hashIterations = hashIterations;
    }

    public void encryptPassword(UserVo user) {

//        user.setSalt(randomNumberGenerator.nextBytes().toHex());
    	user.setPassword("123456");
        String newPassword = new SimpleHash(
                algorithmName,
                user.getPassword(),
                ByteSource.Util.bytes(user.getName()),
                hashIterations).toHex();

        user.setPassword(newPassword);
    }
    public void printStr() {
    	UserVo user=new UserVo();
    	user.setName("wff@cy");
    	user.setPassword("123456");
    	
    	String newPassword = new SimpleHash(
                "md5",
                user.getPassword(),
                ByteSource.Util.bytes(user.getName()),
                2).toHex();

    	
    	System.out.println(newPassword);
	}
}
