package com.github.hirethem.model.dao;

import com.github.hirethem.model.entity.Resume;
import com.github.hirethem.model.entity.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by egorshulga on 30-Apr-16.
 */
public class ResumeDao extends HibernateDao {

    public void addResume(User user, Resume resume) {
        session.beginTransaction();

        user.getResumes().add(resume);

        session.getTransaction().commit();
    }

    public void deleteResume(int resumeId) {
        session.beginTransaction();
        Query query = session.createQuery("delete Resume where id = :resumeId");
        query.setParameter("resumeId", resumeId);
        int result = query.executeUpdate();
        session.getTransaction().commit();
    }

    public void modifyResume(int resumeId, String summary, String description, String skills,
                             String interests, String references) {
        session.beginTransaction();

        Resume resume = session.get(Resume.class, resumeId);
        resume.setSummary(summary);
        resume.setDescription(description);
        resume.setSkills(skills);
        resume.setInterests(interests);
        resume.setReferences(references);

        session.getTransaction().commit();
    }

    public Resume getResume(int resumeId) {
        return session.get(Resume.class, resumeId);
    }

    public List<Resume> getResumes(User user) {
        Criteria criteria = session.createCriteria(Resume.class);
        criteria.add(Restrictions.eq("employee", user));
        return criteria.list();
    }

    public List<Resume> getAllResumes() {
        Criteria criteria = session.createCriteria(Resume.class);
        return criteria.list();
    }

}
