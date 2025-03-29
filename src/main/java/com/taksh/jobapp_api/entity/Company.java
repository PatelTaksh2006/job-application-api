package com.taksh.jobapp_api.entity;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Companyid;

    @Transient
    private String password;
    private String name;
    private String industry;
    private String location;
    private String email;
    @OneToMany(mappedBy="company",cascade = CascadeType.ALL)
    @JsonIgnore  // Prevent infinite recursion
    private List<Job> jobs;

    
    

    public Company() {
//		super();
	}

	public int getCompanyid() {
		return Companyid;
	}

	public void setCompanyid(int companyid) {
		Companyid = companyid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}
