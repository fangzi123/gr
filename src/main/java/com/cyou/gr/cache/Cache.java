package com.cyou.gr.cache;

import java.util.concurrent.TimeoutException;

import net.rubyeye.xmemcached.GetsResponse;
import net.rubyeye.xmemcached.exception.MemcachedException;

/**
 * memcached 操作接口
 * @version 1.00
 * @since 20140414
 * @author xiaojianyu
 */
public interface Cache {

    /**
     * 存储 key-value，无失效时间
     * @param key
     * @param value
     * @throws TimeoutException
     * @throws InterruptedException
     * @throws MemcachedException
     * @author xiaojianyu
     */
    void put(String key, Object value) throws TimeoutException, InterruptedException, MemcachedException;

    /**
     * 存储 key-value，指定失效时间
     * @param key
     * @param exp
     * @param value
     * @throws TimeoutException
     * @throws InterruptedException
     * @throws MemcachedException
     * @author xiaojianyu
     */
    void put(String key, int exp, Object value) throws TimeoutException, InterruptedException, MemcachedException;
    
    /**
     * 通过 key，获取value
     * @param key
     * @return
     * @throws TimeoutException
     * @throws InterruptedException
     * @throws MemcachedException
     * @author xiaojianyu
     */
    Object get(String key) throws TimeoutException, InterruptedException, MemcachedException;

    /**
     * 自增加指定数量的值，并返回增加后的数值
     * @param key
     * @param num
     * @return
     * @throws TimeoutException
     * @throws InterruptedException
     * @throws MemcachedException
     * @author xiaojianyu
     */
    Long incrementAndGet(String key, long num) throws TimeoutException, InterruptedException, MemcachedException;

    /**
     * 自减小指定数量的值，并返回减小后的数值
     * @param key
     * @param num
     * @return
     * @throws TimeoutException
     * @throws InterruptedException
     * @throws MemcachedException
     * @author xiaojianyu
     */
    Long decrementAndGet(String key, long num) throws TimeoutException, InterruptedException, MemcachedException;

    /**
     * 删除指定的key
     * @param key
     * @throws TimeoutException
     * @throws InterruptedException
     * @throws MemcachedException
     * @author xiaojianyu
     */
    void remove(String key) throws TimeoutException, InterruptedException, MemcachedException;

    /**
     * 获取cas的值
     * @param key
     * @return
     * @throws TimeoutException
     * @throws InterruptedException
     * @throws MemcachedException
     * @author xiaojianyu
     */
    GetsResponse<Object> getCas(String key) throws TimeoutException, InterruptedException, MemcachedException;

    /**
     * 根据cas规则存储值
     * @param key
     * @param value
     * @param cas
     * @return
     * @throws TimeoutException
     * @throws InterruptedException
     * @throws MemcachedException
     * @author xiaojianyu
     */
    boolean putCas(String key, Object value, long cas) throws TimeoutException, InterruptedException,
            MemcachedException;
}
