package com.github.hirethem.model.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.net.URL;

/**
 * Created by egorshulga.
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static Configuration config;

    static {
        String path = "/hibernate.cfg.xml";
        URL url = HibernateUtil.class.getResource(path);
        config = new Configuration().configure(url);
        sessionFactory = config.buildSessionFactory();
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }
}
