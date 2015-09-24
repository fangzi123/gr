package com.cyou.gr.memSession;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;

import com.cyou.gr.cache.service.CacheService;



/**
 *
 * @author user
 *
 */
public class MemSessionDAO extends AbstractSessionDAO {
    private String keyPrefix = "shiro_session:";
    private int MIN = 1800;
    @Autowired
    private CacheService cacheService;

    @Override
    public void delete(Session session) {
        String key = getSessionKey(session);
        cacheService.removeCache(key);
    }

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = this.generateSessionId(session);
        this.assignSessionId(session, sessionId);
        this.update(session);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        String key = keyPrefix + sessionId;
        return (Session) cacheService.getCache(key);
    }

    @Override
    public Collection<Session> getActiveSessions() {
        Set<String> set = cacheService.keys(keyPrefix + "*");
        Set<Session> sessions = new HashSet<Session>();
        for (String key : set) {
            sessions.add((Session) cacheService.getCache(key));
        }
        return sessions;
    }

    private String getSessionKey(Session session) {
        return keyPrefix + session.getId();
    }

    @Override
    public void update(Session session) throws UnknownSessionException {
        String key = getSessionKey(session);
        cacheService.putCache(key, MIN, session);
    }

    public void setKeyPrefix(String keyPrefix) {
        this.keyPrefix = keyPrefix;
    }

}
