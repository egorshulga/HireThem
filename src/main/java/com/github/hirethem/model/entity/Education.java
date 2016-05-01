package com.github.hirethem.model.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by egors.
 */
@Entity
@Table(name = "educations")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "resume_id")
    private Resume resume;

    @Column(name = "university")
    private String university;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "specialty")
    private String specialty;

    @Column(name = "degree")
    private String degree;

    @Column(name = "description")
    private String description;

    public Education() {
    }

    public Education(String university, Date startDate, Date endDate, String specialty, String degree, String description, Resume resume) {
        this.university = university;
        this.startDate = startDate;
        this.endDate = endDate;
        this.specialty = specialty;
        this.degree = degree;
        this.description = description;
        this.resume = resume;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startYear) {
        this.startDate = startYear;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endYear) {
        this.endDate = endYear;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
