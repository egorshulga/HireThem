package com.github.hirethem.model.dao;

import com.github.hirethem.listener.HibernateListener;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by egors.
 */
public class HibernateDao {

    protected Session session = ((SessionFactory) ServletActionContext.getServletContext()
            .getAttribute(HibernateListener.getKeyName())).openSession();

}
