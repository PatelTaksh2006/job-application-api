package com.taksh.jobapp_api.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Applicantid;
    
    @Transient
    private String password;
    
	private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String currentCompany;
    private String currentJobTitle; 
    private String skills; // Comma-separated values (e.g., "Java, Spring Boot, SQL")
    private int experience; // Years
    private String education;

    @ManyToMany
    @JoinTable(name="Applied_job",joinColumns=@JoinColumn(name="applicant_id",referencedColumnName="Applicantid"),
    inverseJoinColumns=@JoinColumn(name="job_id",referencedColumnName="Jobid"))
    private List<Job> appliedJobs;
    
    
    public int getApplicantid() {
		return Applicantid;
	}

	public void setApplicantid(int applicantid) {
		Applicantid = applicantid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCurrentCompany() {
        return currentCompany;
    }

    public void setCurrentCompany(String currentCompany) {
        this.currentCompany = currentCompany;
    }

    public String getCurrentJobTitle() {
        return currentJobTitle;
    }

    public void setCurrentJobTitle(String currentJobTitle) {
        this.currentJobTitle = currentJobTitle;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

	public List<Job> getAppliedJobs() {
		return appliedJobs;
	}

	public void setAppliedJobs(List<Job> appliedJobs) {
		this.appliedJobs = appliedJobs;
	}
    
    
}
