package com.cyou.gr;
 

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import com.cyou.gr.cache.service.CacheService;
import com.cyou.gr.comm.AbstractSpringContextTestSupport;

@WebAppConfiguration 
public class TestMemcached extends AbstractSpringContextTestSupport{
	@Autowired
	private CacheService cacheService;
    @Test
    public void testIt(){
        try {
            MemcachedClient client = new XMemcachedClient("127.0.0.1", 11211);
            String testVal = "this is a test demo.";
            client.set("test_key", 10, testVal);
            Thread.sleep(5000);
            System.out.println("=================" + client.get("test_key"));
            Thread.sleep(15000);
            System.out.println("=================" + client.get("test_key"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TimeoutException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MemcachedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
     
    @Test
    public void test(){
    	String cacheKey ="wff";
		cacheService.putCache(cacheKey, "1024904798");
		System.out.println("wff--------------"+cacheService.getCache(cacheKey));
    }
    
    @Test
    public void test1(){
    	String cacheKey ="wff";
		System.out.println("--------------"+cacheService.getCache(cacheKey));
    }
}