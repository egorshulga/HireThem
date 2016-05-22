package com.github.hirethem.action.resumes;

import com.github.hirethem.action.interceptor.AuthorizeAs;
import com.github.hirethem.model.entity.Education;
import com.github.hirethem.model.entity.Resume;
import com.github.hirethem.model.entity.WorkExperience;
import com.github.hirethem.model.service.ResumeService;
import com.github.hirethem.model.service.SessionService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by egorshulga on 06-May-16.
 */
@AuthorizeAs(userType = "EMPLOYEE")
public class ModifyResumeAction extends ActionSupport {

    private int resumeId;

    private String summary;
    private String interests;
    private String references;
    private String description;
    private String skills;
    private Education education;
    private WorkExperience workExperience;

    public String input() {
        Resume resume = new ResumeService().getResume(resumeId);
        new SessionService().put("resumeId", resumeId);
        summary = resume.getSummary();
        interests = resume.getInterests();
        references = resume.getReferences();
        description = resume.getDescription();
        skills = resume.getSkills();
        if (!resume.getEducations().isEmpty()) {
            education = (Education) resume.getEducations().toArray()[0];
        }
        if (!resume.getWorkExperiences().isEmpty()) {
            workExperience = (WorkExperience) resume.getWorkExperiences().toArray()[0];
        }
        return INPUT;
    }

    public String execute() {
        resumeId = (int) new SessionService().getValue("resumeId");
        new ResumeService().modifyResume(resumeId, summary, description, skills, interests, references);
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

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public WorkExperience getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(WorkExperience workExperience) {
        this.workExperience = workExperience;
    }
}
