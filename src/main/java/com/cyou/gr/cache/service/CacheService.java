package com.cyou.gr.cache.service;

import java.util.Set;

/**
 * 缓存操作接口定义
 * @author xiaojianyu
 *
 */
public interface CacheService {

	/**
	 * put 缓存 （无失效时间）
	 * @author liujinshan
	 * @param cacheKey
	 * @param object
	 */
	void putValidCache(String cacheKey,Object object);

	/**
	 * put 缓存，灵活设置失效时间,失效时间必须小于30天，如果设置大于30天，会直接失效
	 * @param cacheKey
	 * @param exp 单位秒 
	 * @param object
	 * @author xiaojianyu
	 */
    void putCache(String cacheKey,int exp,Object object);
    
    /**
     * put 缓存
     * @author liujinshan
     * @param cacheKey
     * @param object
     */
    void putCache(String cacheKey,Object object);
    
    /**
     * remove 缓存
     * @author liujinshan
     * @param cacheKey
     */
    void removeCache(String cacheKey);
    
    /**
     * get 缓存
     * @author liujinshan
     * @param cacheKey
     * @return
     */
    Object getCache(String cacheKey);

	Set<String> keys(String string);
    
    
    
}
