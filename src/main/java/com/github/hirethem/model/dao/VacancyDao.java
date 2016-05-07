package com.github.hirethem.model.dao;

import com.github.hirethem.model.entity.User;
import com.github.hirethem.model.entity.Vacancy;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by egorshulga on 30-Apr-16.
 */
public class VacancyDao extends HibernateDao {

    public void addVacancy(User user, Vacancy vacancy) {
        session.beginTransaction();

        user.getVacancies().add(vacancy);

        session.getTransaction().commit();
    }

    public void deleteVacancy(int vacancyId) {
        session.beginTransaction();
        Query query = session.createQuery("delete Vacancy where id = :vacancyId");
        query.setParameter("vacancyId", vacancyId);
        int result = query.executeUpdate();
        session.getTransaction().commit();
    }

    public void modifyVacancy(int vacancyId, String title, String summary, String description,
                              String salary, String requiredExperience, String requiredSkills) {
        session.beginTransaction();

        Vacancy vacancy = session.get(Vacancy.class, vacancyId);
        vacancy.setTitle(title);
        vacancy.setSummary(summary);
        vacancy.setDescription(description);
        vacancy.setSalary(salary);
        vacancy.setRequiredExperience(requiredExperience);
        vacancy.setRequiredSkills(requiredSkills);

        session.getTransaction().commit();
    }

    public Vacancy getVacancy(int vacancyId) {
        return session.get(Vacancy.class, vacancyId);
    }

    public List<Vacancy> getVacancies(User user) {
        Criteria criteria = session.createCriteria(Vacancy.class);
        criteria.add(Restrictions.eq("employer", user));
        return criteria.list();
    }

    public List<Vacancy> getAllVacancies() {
        Criteria criteria = session.createCriteria(Vacancy.class);
        return criteria.list();
    }
}
