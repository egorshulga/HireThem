package com.github.hirethem.model.dao;

import com.github.hirethem.listener.HibernateListener;
import com.github.hirethem.model.dao.exception.DaoException;
import com.github.hirethem.model.entity.User;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 * Created by egors.
 */
public class LoginDao {

    private Session session = ((SessionFactory) ServletActionContext.getServletContext()
            .getAttribute(HibernateListener.getKeyName())).openSession();


    public byte[] getSalt(String email) throws DaoException {
        User user = getUser(email);
        return user.getPasswordSalt();
    }

    public byte[] getEncryptedPassword(String email) throws DaoException {
        User user = getUser(email);
        return user.getEncryptedPassword();
    }

    private User getUser(String email) throws DaoException {
        Criteria criteria = session.createCriteria(User.class);
        if (email != null) {
            criteria.add(Restrictions.eq("email", email));
        } else {
            throw new DaoException("Email cannot be null");
        }
        User user;
        try {
            user = (User) criteria.list().get(0);
        } catch (ClassCastException e) {
            throw new DaoException("Non-user entities retrieved from `users` table.", e);
        } catch (IndexOutOfBoundsException e) {
            throw new DaoException("There are no users with this email", e);
        }
        return user;
    }

}
