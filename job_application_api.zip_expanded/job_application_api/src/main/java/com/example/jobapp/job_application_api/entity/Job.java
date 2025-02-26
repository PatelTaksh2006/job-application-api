package com.example.jobapp.job_application_api.entity;
import jakarta.persistence.*;
import java.util.*;
@Entity
public class Job {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;             
    private String description;              
    private String jobType;
//    private String requiredSkills;   // Comma-separated list 
    private String experienceLevel; // Entry, Mid, Senior level
    private String location;
    private double salary;
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
    
    @ManyToMany
    @JoinTable(
            name = "job_applicants",
            joinColumns = @JoinColumn(name = "job_id"),
            inverseJoinColumns = @JoinColumn(name = "applicant_id")
        )
    private List<Applicant> applicants=new ArrayList<>();
	public Job() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public String getExperienceLevel() {
		return experienceLevel;
	}
	public void setExperienceLevel(String experienceLevel) {
		this.experienceLevel = experienceLevel;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	
	public List<Applicant> getApplicants() {
		return applicants;
	}
	public void setApplicants(List<Applicant> applicants) {
		this.applicants = applicants;
	}
	@Override
	public String toString() {
		return "Job [id=" + id + ", title=" + title + ", description=" + description + ", jobType=" + jobType
				+ ", experienceLevel=" + experienceLevel + ", location=" + location + ", salary=" + salary
				+ ", company=" + company + ", applicants=" + applicants + "]";
	}
	
	
    
}

