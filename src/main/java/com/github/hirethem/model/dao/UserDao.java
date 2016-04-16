package com.github.hirethem.model.dao;

import com.github.hirethem.model.dao.exception.DaoException;
import com.github.hirethem.model.entity.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import static com.github.hirethem.model.dao.exception.DaoErrorMessages.NOT_FOUND_USER;

/**
 * Created by egors.
 */
public class UserDao extends HibernateDao {

    public byte[] getSalt(String email) throws DaoException {
        User user = getUser(email);
        return user.getPasswordSalt();
    }

    public byte[] getEncryptedPassword(String email) throws DaoException {
        User user = getUser(email);
        return user.getEncryptedPassword();
    }

    public User getUser(String email) throws DaoException {
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("email", email));
        User user;
        try {
            user = (User) criteria.list().get(0);
        } catch (IndexOutOfBoundsException e) {
            throw new DaoException(NOT_FOUND_USER, e);
        }
        return user;
    }

    public void createNewUser(String email, byte[] encryptedPassword, byte[] salt, String name,
                              String surname, User.UserType userType) {
        session.beginTransaction();
        User user = new User(email, encryptedPassword, salt, name, surname, userType);
        session.save(user);
        session.getTransaction().commit();
    }


}
