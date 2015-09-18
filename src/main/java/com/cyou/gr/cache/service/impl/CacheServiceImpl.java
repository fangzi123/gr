package com.cyou.gr.cache.service.impl;


import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyou.gr.cache.Cache;
import com.cyou.gr.cache.service.CacheService;

import net.rubyeye.xmemcached.exception.MemcachedException;


/**
 * 缓存操作接口实现
 * 
 * @author xiaojianyu
 */
@Service
public class CacheServiceImpl implements CacheService {

    private static Logger log = LoggerFactory.getLogger(CacheServiceImpl.class);

    /** 失效时间常量 **/
    private static final int EXPIRE = 60 * 60 * 24 * 10;// 失效时间为10天
    
    @Autowired
    private Cache cache;

    public void putCache(String cacheKey,Object object) {
        try {
            cache.put(cacheKey,EXPIRE,object);
        } catch (TimeoutException e) {
            log.error("timeout, cacheKey:" + cacheKey, e);
        } catch (InterruptedException e) {
            log.error("interrupt, cacheKey:" + cacheKey, e);
        } catch (MemcachedException e) {
            log.error("memcachedException, cacheKey:" + cacheKey, e);
        } catch (Exception e) {
            log.error("exception, cacheKey:" + cacheKey, e);
        }
    }
    
    public void putCache(String cacheKey,int exp,Object object) {
        try {
            cache.put(cacheKey,exp,object);
        } catch (TimeoutException e) {
            log.error("timeout, cacheKey:" + cacheKey, e);
        } catch (InterruptedException e) {
            log.error("interrupt, cacheKey:" + cacheKey, e);
        } catch (MemcachedException e) {
            log.error("memcachedException, cacheKey:" + cacheKey, e);
        } catch (Exception e) {
            log.error("exception, cacheKey:" + cacheKey, e);
        }
    }
    
    public void removeCache(String cacheKey) {
        try {
            cache.remove(cacheKey);
        } catch (TimeoutException e) {
            log.error("timeout, cacheKey:" + cacheKey, e);
        } catch (InterruptedException e) {
            log.error("interrupt, cacheKey:" + cacheKey, e);
        } catch (MemcachedException e) {
            log.error("memcachedException, cacheKey:" + cacheKey, e);
        } catch (Exception e) {
            log.error("exception, cacheKey:" + cacheKey, e);
        }
    }
    
    public Object getCache(String cacheKey) {
    	Object object = null;
        try {
        	object = (Object) cache.get(cacheKey);
        } catch (TimeoutException e) {
            log.error("timeout, cacheKey:" + cacheKey, e);
        } catch (InterruptedException e) {
            log.error("interrupt, cacheKey:" + cacheKey, e);
        } catch (MemcachedException e) {
            log.error("memcachedException, cacheKey:" + cacheKey, e);
        } catch (Exception e) {
            log.error("exception, cacheKey:" + cacheKey, e);
        }
        return object;
    }

	public void putValidCache(String cacheKey, Object object) {
		 try {
	            cache.put(cacheKey,object);
	        } catch (TimeoutException e) {
	            log.error("timeout, cacheKey:" + cacheKey, e);
	        } catch (InterruptedException e) {
	            log.error("interrupt, cacheKey:" + cacheKey, e);
	        } catch (MemcachedException e) {
	            log.error("memcachedException, cacheKey:" + cacheKey, e);
	        } catch (Exception e) {
	            log.error("exception, cacheKey:" + cacheKey, e);
	        }
	}
}
