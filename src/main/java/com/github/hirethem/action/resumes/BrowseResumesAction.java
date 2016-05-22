package com.github.hirethem.action.resumes;

import com.github.hirethem.model.entity.Resume;
import com.github.hirethem.model.service.ResumeService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by egorshulga on 06-May-16.
 */
public class BrowseResumesAction extends ActionSupport {

    private ResumeService resumeService = new ResumeService();

    private String summaryToSearch;
    private String skillsToSearch;
    private String educationToSearch;
    private String experienceToSearch;

    private List<Resume> resumes;

    public String input() {
        resumes = resumeService.getAllResumes();
        return INPUT;
    }

    public String searchBySummary() {
        if (StringUtils.isBlank(summaryToSearch)) {
            return INPUT;
        }
        resumes = resumeService.findResumesUsingSummary(summaryToSearch);
        return SUCCESS;
    }

    public String searchBySkills() {
        if (StringUtils.isBlank(skillsToSearch)) {
            return INPUT;
        }
        resumes = resumeService.findResumesUsingSkills(skillsToSearch);
        return SUCCESS;
    }

    public String searchByEducation() {
        if (StringUtils.isBlank(educationToSearch)) {
            return INPUT;
        }
        resumes = resumeService.findResumesUsingEducation(educationToSearch);
        return SUCCESS;
    }

    public String searchByExperience() {
        if (StringUtils.isBlank(experienceToSearch)) {
            return INPUT;
        }
        resumes = resumeService.findResumesUsingWorkExperience(educationToSearch);
        return SUCCESS;
    }

    public String getSummaryToSearch() {
        return summaryToSearch;
    }

    public void setSummaryToSearch(String summaryToSearch) {
        this.summaryToSearch = summaryToSearch;
    }

    public String getSkillsToSearch() {
        return skillsToSearch;
    }

    public void setSkillsToSearch(String skillsToSearch) {
        this.skillsToSearch = skillsToSearch;
    }

    public String getEducationToSearch() {
        return educationToSearch;
    }

    public void setEducationToSearch(String educationToSearch) {
        this.educationToSearch = educationToSearch;
    }

    public String getExperienceToSearch() {
        return experienceToSearch;
    }

    public void setExperienceToSearch(String experienceToSearch) {
        this.experienceToSearch = experienceToSearch;
    }

    public List<Resume> getResumes() {
        return resumes;
    }

    public void setResumes(List<Resume> resumes) {
        this.resumes = resumes;
    }
}
