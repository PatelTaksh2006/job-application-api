package com.taksh.jobapp_api.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Jobid;
    
    private String title;
    private String description;
    private String location;

    
    @ManyToMany(mappedBy="appliedJobs",cascade=CascadeType.ALL)
    @JsonIgnore // Back reference, prevents infinite recursion
  // Prevent infinite recursion
    private List<Applicant> Applicant_List;
    
    @ManyToOne
    @JoinColumn(name="company_id")
    @JsonIgnoreProperties("jobs")  // Prevents infinite loop
    private Company company;
    
    
    public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public int getJobid() {
		return Jobid;
	}

	public void setJobid(int jobid) {
		Jobid = jobid;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


	public List<Applicant> getApplicant_List() {
		return Applicant_List;
	}

	public void setApplicant_List(List<Applicant> applicant_List) {
		Applicant_List = applicant_List;
	}
    
}
