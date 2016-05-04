package com.github.hirethem.model.service;

import com.github.hirethem.model.entity.User;
import com.github.hirethem.model.entity.Vacancy;
import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by egorshulga on 01-May-16.
 */
public class VacancyServiceTest {

    private VacancyService vacancyService;
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

    @Before
    public void setUp() throws Exception {
        vacancyService = new VacancyService();
        userService = new UserService();

        userService.createNewUser(email, userType, name, surname, password);
        int userId = userService.getUserId(email, userType);
        vacancyService.createVacancy(userId, title, summary, description, salary, requiredExperience, requiredSkills
        );
    }

    @After
    public void tearDown() throws Exception {
        userService.deleteUser(email, userType);
    }

    @Test
    public void deleteAndCreateVacancy() throws Exception {
        Vacancy vacancy = vacancyService.findVacanciesUsingTitle(title).get(0);
        vacancyService.deleteVacancy(vacancy.getId());
        vacancyService.createVacancy(userService.getUserId(email, userType), title, summary, description, salary, requiredExperience, requiredSkills
        );
    }

    @Test
    public void modifyVacancy() throws Exception {
        String nothing = "nothing";
        Vacancy vacancy = vacancyService.findVacanciesUsingTitle(title).get(0);
        vacancyService.modifyVacancy(vacancy.getId(), nothing, nothing, nothing, nothing, nothing, nothing, nothing);
        vacancy = vacancyService.findVacanciesUsingTitle(nothing).get(0);
        assertEquals(vacancy.getTitle(), nothing);
        assertEquals(vacancy.getSummary(), nothing);
        assertEquals(vacancy.getDescription(), nothing);
        assertEquals(vacancy.getSalary(), nothing);
        assertEquals(vacancy.getRequiredExperience(), nothing);
        assertEquals(vacancy.getRequiredSkills(), nothing);
    }

    @Test
    public void getVacancy() throws Exception {
        Vacancy vacancy = vacancyService.findVacanciesUsingTitle(title).get(0);
        assertNotNull(vacancy);
    }

    @Test
    public void getVacancies() throws Exception {
        List<Vacancy> vacancies = vacancyService.getVacancies(userService.getUserId(email, userType));
        assertTrue(vacancies.size() > 0);
    }

    @Test
    public void findVacanciesUsingTitle() throws Exception {
        Vacancy vacancy = vacancyService.findVacanciesUsingTitle(title).get(0);
        assertTrue(StringUtils.containsIgnoreCase(vacancy.getTitle(), title));
    }

    @Test
    public void findVacanciesUsingSummary() throws Exception {
        Vacancy vacancy = vacancyService.findVacanciesUsingSummary(summary).get(0);
        assertTrue(StringUtils.containsIgnoreCase(vacancy.getSummary(), summary));
    }

    @Test
    public void findResumesUsingDescription() throws Exception {
        Vacancy vacancy = vacancyService.findResumesUsingDescription(description).get(0);
        assertTrue(StringUtils.containsIgnoreCase(vacancy.getDescription(), description));
    }

    @Test
    public void findResumesUsingRequiredSkills() throws Exception {
        Vacancy vacancy = vacancyService.findResumesUsingRequiredSkills(requiredSkills).get(0);
        assertTrue(StringUtils.containsIgnoreCase(vacancy.getRequiredSkills(), requiredSkills));
    }

    @Test
    public void findResumesUsingRequiredExperience() throws Exception {
        Vacancy vacancy = vacancyService.findResumesUsingRequiredExperience(requiredExperience).get(0);
        assertTrue(StringUtils.containsIgnoreCase(vacancy.getRequiredExperience(), requiredExperience));
    }

    @Test
    public void getAllVacancies() throws Exception {
        List<Vacancy> vacancies = vacancyService.getAllVacancies();
        assertTrue(vacancies.size() > 0);
    }

}