package com.example.jobapp.job_application_api.entity;
import jakarta.persistence.*;

import java.util.*;
@Entity
public class Company {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
    private String industry;         
    private String location;         
    private String website;          
    private String email;            
    private String phoneNumber;
    
    @OneToMany(mappedBy = "company",cascade=CascadeType.ALL)
    private List<Job> jobs=new ArrayList<>();
	public Company() {
//		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "company [id=" + id + ", name=" + name + ", industry=" + industry + ", location=" + location
				+ ", website=" + website + ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
	}
    
	
}

