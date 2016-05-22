package com.github.hirethem.action.resumes;

import com.github.hirethem.action.interceptor.AuthorizeAs;
import com.github.hirethem.model.entity.Education;
import com.github.hirethem.model.entity.Resume;
import com.github.hirethem.model.entity.WorkExperience;
import com.github.hirethem.model.service.EducationsService;
import com.github.hirethem.model.service.ResumeService;
import com.github.hirethem.model.service.SessionService;
import com.github.hirethem.model.service.WorkExperienceService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by egorshulga on 06-May-16.
 */
@AuthorizeAs(userType = "EMPLOYEE")
public class ModifyResumeAction extends ActionSupport {

    private int resumeId;
    private int educationId;
    private int workExperienceId;

    private String summary;
    private String interests;
    private String references;
    private String description;
    private String skills;

    private String degree;
    private String specialty;
    private String university;
    private String educationStartDate;
    private String educationEndDate;
    private String educationDescription;

    private String companyName;
    private String position;
    private String workExperienceStartDate;
    private String workExperienceEndDate;
    private String workExperienceDescription;

    public String input() {
        Resume resume = new ResumeService().getResume(resumeId);
        new SessionService().put("resumeId", resumeId);
        summary = resume.getSummary();
        interests = resume.getInterests();
        references = resume.getReferences();
        description = resume.getDescription();
        skills = resume.getSkills();
        if (!resume.getEducations().isEmpty()) {
            Education education = (Education) resume.getEducations().toArray()[0];
            degree = education.getDegree();
            specialty = education.getSpecialty();
            university = education.getUniversity();
            educationStartDate = education.getStartDate();
            educationEndDate = education.getEndDate();
            educationDescription = education.getDescription();
        }
        if (!resume.getWorkExperiences().isEmpty()) {
            WorkExperience workExperience = (WorkExperience) resume.getWorkExperiences().toArray()[0];
            companyName = workExperience.getCompanyName();
            position = workExperience.getPosition();
            workExperienceStartDate = workExperience.getStartDate();
            workExperienceEndDate = workExperience.getEndDate();
            workExperienceDescription = workExperience.getDescription();
        }
        return INPUT;
    }

    public String execute() {
        resumeId = (int) new SessionService().getValue("resumeId");
        educationId = ((Education) new ResumeService().getResume(resumeId).getEducations().toArray()[0]).getId();
        workExperienceId = ((WorkExperience) new ResumeService().getResume(resumeId).getWorkExperiences().toArray()[0]).getId();
        new ResumeService().modifyResume(resumeId, summary, description, skills, interests, references);
        new EducationsService().modifyEducation(educationId, university, educationStartDate, educationEndDate, specialty, degree, educationDescription);
        new WorkExperienceService().modifyWorkExperience(workExperienceId, companyName, position, workExperienceStartDate, workExperienceEndDate, workExperienceDescription);
        return SUCCESS;
    }

    public void validate() {
        if (StringUtils.isEmpty(summary)) {
            addActionError("Summary cannot be empty");
        }
    }

    public int getResumeId() {
        return resumeId;
    }

    public void setResumeId(int resumeId) {
        this.resumeId = resumeId;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getReferences() {
        return references;
    }

    public void setReferences(String references) {
        this.references = references;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public int getEducationId() {
        return educationId;
    }

    public void setEducationId(int educationId) {
        this.educationId = educationId;
    }

    public int getWorkExperienceId() {
        return workExperienceId;
    }

    public void setWorkExperienceId(int workExperienceId) {
        this.workExperienceId = workExperienceId;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getEducationStartDate() {
        return educationStartDate;
    }

    public void setEducationStartDate(String educationStartDate) {
        this.educationStartDate = educationStartDate;
    }

    public String getEducationEndDate() {
        return educationEndDate;
    }

    public void setEducationEndDate(String educationEndDate) {
        this.educationEndDate = educationEndDate;
    }

    public String getEducationDescription() {
        return educationDescription;
    }

    public void setEducationDescription(String educationDescription) {
        this.educationDescription = educationDescription;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getWorkExperienceStartDate() {
        return workExperienceStartDate;
    }

    public void setWorkExperienceStartDate(String workExperienceStartDate) {
        this.workExperienceStartDate = workExperienceStartDate;
    }

    public String getWorkExperienceEndDate() {
        return workExperienceEndDate;
    }

    public void setWorkExperienceEndDate(String workExperienceEndDate) {
        this.workExperienceEndDate = workExperienceEndDate;
    }

    public String getWorkExperienceDescription() {
        return workExperienceDescription;
    }

    public void setWorkExperienceDescription(String workExperienceDescription) {
        this.workExperienceDescription = workExperienceDescription;
    }
}
