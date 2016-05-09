package com.github.hirethem.action.resumes;

import com.github.hirethem.model.entity.Education;
import com.github.hirethem.model.entity.Resume;
import com.github.hirethem.model.entity.WorkExperience;
import com.github.hirethem.model.service.ResumeService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by egorshulga on 06-May-16.
 */
public class ModifyResumeAction extends AuthorizationRequired {

    private int resumeId;

    private String summary;
    private String interests;
    private String references;
    private String description;
    private String skills;
    private List<Education> educations;             //how to update this???
    private List<WorkExperience> workExperiences;   //how to update this???

    public String input() {
        Resume resume = new ResumeService().getResume(resumeId);
        summary = resume.getSummary();
        interests = resume.getInterests();
        references = resume.getReferences();
        description = resume.getDescription();
        skills = resume.getSkills();
        educations = new ArrayList<>(educations);
        workExperiences = new ArrayList<>(workExperiences);
        return INPUT;
    }

    public String execute() {
        new ResumeService().modifyResume(resumeId, summary, description, skills, interests, references);
        return SUCCESS;
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

    public List<Education> getEducations() {
        return educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    public List<WorkExperience> getWorkExperiences() {
        return workExperiences;
    }

    public void setWorkExperiences(List<WorkExperience> workExperiences) {
        this.workExperiences = workExperiences;
    }
}
