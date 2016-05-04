package com.github.hirethem.model.util;

import au.com.bytecode.opencsv.CSVWriter;
import com.github.hirethem.model.dao.ResumeDao;
import com.github.hirethem.model.dao.UserDao;
import com.github.hirethem.model.dao.VacancyDao;
import com.github.hirethem.model.entity.*;
import org.apache.commons.io.output.ByteArrayOutputStream;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by Kirill on 03.05.2016.
 */
public class SVNGenerationUtil {

    public static ByteArrayOutputStream generateVacanciesInCSV() throws IOException {
        String[] fileHeader = {"Number", "Title", "Summary", "Salary", "Skills", "Experience"};
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        CSVWriter writer = new CSVWriter(new OutputStreamWriter(stream, Charset.forName("UTF-8")), ',');
        writer.writeNext(fileHeader);
        List<String[]> vacanciesInString = new LinkedList<String[]>();
        VacancyDao vacancyDao = new VacancyDao();
        List<Vacancy> vacancyList = vacancyDao.getAllVacancies();
        for (int i = 0; i < vacancyList.size(); i++) {
            Vacancy vacancy = vacancyList.get(i);
            String[] tempArray = { Integer.toString(
                                  vacancy.getId()),
                                  vacancy.getEmployer().getEmail(),
                                  vacancy.getTitle(),
                                  vacancy.getSummary(),
                                  vacancy.getSalary(),
                                  vacancy.getRequiredSkills(),
                                  vacancy.getRequiredExperience()};
            vacanciesInString.add(tempArray);
        }

        writer.writeAll(vacanciesInString);
        writer.close();
        return stream;
    }

    public static ByteArrayOutputStream generateUsersInCSV() throws IOException {
        String[] fileHeader = {"Number", "E-mail", "Usertype", "Name", "Surname", "About", "Contact info", "Is Admin"};
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        CSVWriter writer = new CSVWriter(new OutputStreamWriter(stream, Charset.forName("UTF-8")), ',');
        writer.writeNext(fileHeader);
        List<String[]> usersInString = new LinkedList<String[]>();
        UserDao userDao = new UserDao();
        List<User> userList = userDao.getAllUsers();
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            String[] tempArray = { Integer.toString(
                    user.getId()),
                    user.getEmail(),
                    user.getUserType().toString(),
                    user.getName(),
                    user.getSurname(),
                    user.getAbout(),
                    user.getContactInfo(),
                    Boolean.toString(user.isAdmin())};
            usersInString.add(tempArray);
        }

        writer.writeAll(usersInString);
        writer.close();
        return stream;
    }

    public static ByteArrayOutputStream generateResumesInCSV() throws IOException {
        String[] fileHeader = {"Number", "Employee", "Summary", "Skills", "Education", "Experience"};
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        CSVWriter writer = new CSVWriter(new OutputStreamWriter(stream, Charset.forName("UTF-8")), ',');
        writer.writeNext(fileHeader);
        List<String[]> resumesInString = new LinkedList<String[]>();
        ResumeDao resumeDao = new ResumeDao();
        List<Resume> resumeList = resumeDao.getAllResumes();
        for (int i = 0; i < resumeList.size(); i++) {
            Resume resume = resumeList.get(i);
            Set<Education> educationList = resume.getEducations();
            String newTempEducation = "";
            for (Education temp : educationList){
                newTempEducation = temp.getUniversity() + "\n" + temp.getSpecialty();
            }
            Set<WorkExperience> workExperiencesSet = resume.getWorkExperiences();
            String newTempExperience = "";
            for (WorkExperience temp : workExperiencesSet){
                newTempExperience = temp.getCompanyName() + "\n" + temp.getDescription();
            }
            String[] tempArray = { Integer.toString(
                    resume.getId()),
                    resume.getEmployee().getEmail(),
                    resume.getSummary(),
                    resume.getSkills(),
                    newTempEducation,
                    newTempExperience};
            resumesInString.add(tempArray);
        }

        writer.writeAll(resumesInString);
        writer.close();
        return stream;
    }

    public static ByteArrayOutputStream generateResumeInCSV(int resumeId) throws IOException {
        String[] fileHeader = {"Number", "Employee", "Summary", "Skills", "Education", "Experience", "Description", "Interests"};
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        CSVWriter writer = new CSVWriter(new OutputStreamWriter(stream, Charset.forName("UTF-8")), ',');
        writer.writeNext(fileHeader);
        List<String[]> resumeInString = new LinkedList<String[]>();
        ResumeDao resumeDao = new ResumeDao();

        Resume resume =  resumeDao.getResume(resumeId);
        Set<Education> educationList = resume.getEducations();
        String newTempEducation = "";
        for (Education temp : educationList){
            newTempEducation = temp.getUniversity() + "\n" + temp.getSpecialty();
        }
        Set<WorkExperience> workExperiencesSet = resume.getWorkExperiences();
        String newTempExperience = "";
        for (WorkExperience temp : workExperiencesSet){
            newTempExperience = temp.getCompanyName() + "\n" + temp.getDescription();
        }
        String[] tempArray = { Integer.toString(
                resume.getId()),
                resume.getEmployee().getEmail(),
                resume.getSummary(),
                resume.getSkills(),
                newTempEducation,
                newTempExperience,
                resume.getDescription(),
                resume.getInterests()};
        resumeInString.add(tempArray);

        writer.writeAll(resumeInString);
        writer.close();
        return stream;
    }

    public static ByteArrayOutputStream generateVacancyInCSV(int vacancyId) throws IOException {
        String[] fileHeader = {"Number", "Employeer", "Title", "Summary", "Salary", "Experience", "Description", "Skills"};
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        CSVWriter writer = new CSVWriter(new OutputStreamWriter(stream, Charset.forName("UTF-8")), ',');
        writer.writeNext(fileHeader);
        List<String[]> vacancyInString = new LinkedList<String[]>();
        VacancyDao vacancyDao = new VacancyDao();

        Vacancy vacancy =  vacancyDao.getVacancy(vacancyId);

        String[] tempArray = { Integer.toString(
                vacancy.getId()),
                vacancy.getEmployer().getEmail(),
                vacancy.getTitle(),
                vacancy.getSummary(),
                vacancy.getSalary(),
                vacancy.getRequiredExperience(),
                vacancy.getDescription(),
                vacancy.getRequiredSkills()};
        vacancyInString.add(tempArray);

        writer.writeAll(vacancyInString);
        writer.close();
        return stream;
    }

}
