package com.cyou.gr.cache.impl;


import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyou.gr.cache.Cache;

import net.rubyeye.xmemcached.GetsResponse;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;

/**
 * memcached 操作接口实现
 * @version 1.00
 * @since 20140414
 * @author xiaojianyu
 */
@Service
public class CacheImpl implements Cache {

    private static Logger log = LoggerFactory.getLogger(CacheImpl.class);
    
    @Autowired
    private MemcachedClient memcachedClient;

    private CacheImpl() {

    }

    public MemcachedClient getMemcachedClient() {
        return memcachedClient;
    }

    public void setMemcachedClient(MemcachedClient memcachedClient) {
        this.memcachedClient = memcachedClient;
    }

    public Long decrementAndGet(String key, long num) throws TimeoutException, InterruptedException, MemcachedException {
        Long value = 0L;
        value = memcachedClient.decr(key, num, -1l);
        return value;
    }

    public Long incrementAndGet(String key, long num) throws TimeoutException, InterruptedException, MemcachedException {
        Long temp = memcachedClient.incr(key, num); // NOTE 注意负数情况 fix me
        return temp;
    }

    public void put(String key, Object value) throws TimeoutException, InterruptedException, MemcachedException {
        try {
            long startTime = System.currentTimeMillis();
            memcachedClient.set(key, 0, value);
            long time = System.currentTimeMillis() - startTime;
            if (time > 5) {
                log.info("put key:" + key + ",time:" + time);
            }
        } catch (TimeoutException e) {
            log.error("put TimeoutException key:" + key);
            throw e;
        } catch (InterruptedException e) {
            log.error("put InterruptedException key:" + key);
            throw e;
        } catch (MemcachedException e) {
            log.error("put InterruptedException key:" + key);
            throw e;
        }
    }

    public void put(String key, int exp, Object value) throws TimeoutException, InterruptedException,
            MemcachedException {
        try {
            long startTime = System.currentTimeMillis();
            memcachedClient.set(key, exp, value);
            long endTime = System.currentTimeMillis() - startTime;
            if (endTime > 5) {
                log.info("put key:" + key + ",time:" + endTime);
            }
        } catch (TimeoutException e) {
            log.error("put TimeoutException key:" + key);
            throw e;
        } catch (InterruptedException e) {
            log.error("put InterruptedException key:" + key);
            throw e;
        } catch (MemcachedException e) {
            log.error("put InterruptedException key:" + key);
            throw e;
        }
    }

    public void remove(String key) throws TimeoutException, InterruptedException, MemcachedException {
        memcachedClient.delete(key);
    }

    public Object get(String key) throws TimeoutException, InterruptedException, MemcachedException {
        Object ret = null;
        try {
            long startTime = System.currentTimeMillis();
            ret = memcachedClient.get(key);
            long endTime = System.currentTimeMillis() - startTime;
            if (endTime > 5) {
                log.info("get key:" + key + ",time:" + endTime);
            }
        } catch (TimeoutException e) {
            log.error("get TimeoutException key:" + key);
            throw e;
        } catch (InterruptedException e) {
            log.error("get InterruptedException key:" + key);
            throw e;
        } catch (MemcachedException e) {
            log.error("get InterruptedException key:" + key);
            throw e;
        }
        return ret;
    }

    public GetsResponse<Object> getCas(String key) throws TimeoutException, InterruptedException, MemcachedException {
        return memcachedClient.gets(key);
    }

    public boolean putCas(String key, Object value, long cas) throws TimeoutException, InterruptedException,
            MemcachedException {
        return memcachedClient.cas(key, 0, value, cas);
    }
}
