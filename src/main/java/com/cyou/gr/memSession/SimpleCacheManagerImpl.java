package com.cyou.gr.memSession;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;

import net.rubyeye.xmemcached.MemcachedClient;

/**
 * 
 * 缓存管理器实现类
 * 
 * @author shadow
 * 
 */
public class SimpleCacheManagerImpl implements SimpleCacheManager {

	private MemcachedClient memcachedClient;

	public SimpleCacheManagerImpl(MemcachedClient memcachedClient) {
		if (memcachedClient == null) {
			throw new RuntimeException("必须存在memcached客户端实例");
		}
		this.memcachedClient = memcachedClient;
	}

	@Override
	public void createCache(String name, Cache<Object, Object> cache) throws CacheException {
		try {
			memcachedClient.set(name, 0, cache);
		} catch (Exception e) {
			throw new CacheException(e);
		}
	}

	@Override
	public Cache<Object, Object> getCache(String name) throws CacheException {
		try {
			return memcachedClient.get(name);
		} catch (Exception e) {
			throw new CacheException(e);
		}
	}

	@Override
	public void removeCache(String name) throws CacheException {
		try {
			memcachedClient.delete(name);
		} catch (Exception e) {
			throw new CacheException(e);
		}
	}

	@Override
	public void updateCahce(String name, Cache<Object, Object> cache) throws CacheException {
		try {
			memcachedClient.replace(name, 0, cache);
		} catch (Exception e) {
			throw new CacheException(e);
		}
	}

	@Override
	public void destroy() throws CacheException {
		try {
			memcachedClient.shutdown();
		} catch (Exception e) {
			throw new CacheException(e);
		}
	}
	

}