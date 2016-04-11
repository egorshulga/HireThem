package com.github.hirethem.model.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by egors.
 */
@Entity
@Table(name = "educations")
public class Education {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private int id;
    @Column(name = "resume_id")
    private int resumeId;
    @Column(name = "university")
    private String university;
    @Column(name = "start_year")
    private int startYear;
    @Column(name = "end_year")
    private int endYear;
    @Column(name = "study_field")
    private String studyField;
    @Column(name = "description")
    private String description;

    public Education() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getResumeId() {
        return resumeId;
    }

    public void setResumeId(int resumeId) {
        this.resumeId = resumeId;
    }

    public String getUnivercity() {
        return university;
    }

    public void setUnivercity(String univercity) {
        this.university = univercity;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public String getStudyField() {
        return studyField;
    }

    public void setStudyField(String studyField) {
        this.studyField = studyField;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
