package com.github.hirethem.model.dao;

import com.opensymphony.xwork2.ActionContext;

import java.util.Map;

/**
 * Created by egors.
 */
public class SessionDao {

    private static Map<String, Object> sessionMap = ActionContext.getContext().getSession();

    public void put(String key, Object value) {
        sessionMap.put(key, value);
    }

    public Object getValue(String key) {
        return sessionMap.get(key);
    }

    public void remove(String key) {
        sessionMap.remove(key);
    }

}
