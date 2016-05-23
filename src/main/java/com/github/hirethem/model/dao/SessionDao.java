package com.github.hirethem.model.dao;

import com.opensymphony.xwork2.ActionContext;

import java.util.Map;

/**
 * Created by egors.
 */
public class SessionDao {

    private static Map<String, Object> sessionMap;

    static  {
        while (sessionMap == null) {
            sessionMap = ActionContext.getContext().getSession();
        }
    }

    public synchronized void put(String key, Object value) {
        if (sessionMap == null) {
            sessionMap = ActionContext.getContext().getSession();
        }
        sessionMap.put(key, value);
    }

    public synchronized Object getValue(String key) {
        return sessionMap.get(key);
    }

    public synchronized boolean containsValue(Object value) {
        return sessionMap.containsValue(value);
    }

    public synchronized void remove(String key) {
        sessionMap.remove(key);
    }

}
