package com.github.hirethem.model.dao;

import com.github.hirethem.model.util.HibernateUtil;
import org.hibernate.Session;

/**
 * Created by egorshulga on 29-Apr-16.
 */
public class HibernateDao {

    protected Session session = HibernateUtil.getSession();

}
