package com.github.hirethem.model.dao;

import com.github.hirethem.model.entity.User;
import com.github.hirethem.model.entity.Vacancy;
import com.github.hirethem.model.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by egorshulga on 01-May-16.
 */
public class VacancyDaoTest {

    private VacancyDao vacancyDao;

    private UserService userService;

    private String email = "mr@ololo.com";
    private String password = "ololo";
    private String name = "Mr";
    private String surname = "Ololo";
    private User.UserType userType = User.UserType.EMPLOYER;

    private String title = "Web programmer";
    private String summary = "Web service, RESTFul, Spring";
    private String description = "This Senior Software Engineer will play hands on web services developer role within the PPA team in a Scrum Agile environment. This candidate will be responsible for the creation of quality web service based software components that are used by PPA customers. The Senior Software Engineer will work closely with Tech.Lead and deliver quality, scalable capabilities on time. He/she will be expected to provide guidance and mentoring other developers.";
    private String salary = "42";
    private String requiredExperience = "Bachelor's degree in computer science or related discipline is preferable" +
            "Deep knowledge and development experience of Web service platforms and middle tier technologies";
    private String requiredSkills = "Java, J2EE, Maven" +
            "OOP" +
            "Motivated, self-directed, aptitude for learning and a team player" +
            "Git, Stash" +
            "Web containers(preferably Tomcat)";
    private String contactInfo = "+375 44 1234567";

    private User user;
    private Vacancy vacancy;

    private String nothing = "nothing";

    @Before
    public void setUp() throws Exception {
        vacancyDao = new VacancyDao();
        userService = new UserService();

        userService.createNewUser(email, userType, name, surname, password);
        user = userService.getUser(email, userType);
        vacancy = new Vacancy();
        vacancy.setTitle(title);
        vacancy.setSummary(summary);
        vacancy.setDescription(description);
        vacancy.setSalary(salary);
        vacancy.setRequiredExperience(requiredExperience);
        vacancy.setRequiredSkills(requiredSkills);
        vacancy.setContactInfo(contactInfo);
        vacancy.setEmployer(user);
        vacancyDao.addVacancy(user, vacancy);
    }

    @After
    public void tearDown() throws Exception {
        userService.deleteUser(user.getId());
    }

    @Test
    public void modifyVacancy() throws Exception {
        vacancyDao.modifyVacancy(vacancy.getId(), nothing, nothing, nothing, nothing, nothing, nothing, nothing);
        vacancy = vacancyDao.getVacancy(vacancy.getId());
        assertEquals(vacancy.getTitle(), nothing);
        assertEquals(vacancy.getSummary(), nothing);
        assertEquals(vacancy.getDescription(), nothing);
        assertEquals(vacancy.getSalary(), nothing);
        assertEquals(vacancy.getRequiredExperience(), nothing);
        assertEquals(vacancy.getRequiredSkills(), nothing);
        assertEquals(vacancy.getContactInfo(), nothing);
    }

    @Test
    public void getVacancy() throws Exception {
        vacancy = vacancyDao.getVacancy(vacancy.getId());
        assertNotNull(vacancy);
    }

    @Test
    public void getVacancies() throws Exception {
        List<Vacancy> vacancies = vacancyDao.getVacancies(user);
        assertTrue(vacancies.size() > 0);
    }

    @Test
    public void getAllVacancies() throws Exception {
        List<Vacancy> vacancies = vacancyDao.getAllVacancies();
        assertTrue(vacancies.size() > 0);
   }

}