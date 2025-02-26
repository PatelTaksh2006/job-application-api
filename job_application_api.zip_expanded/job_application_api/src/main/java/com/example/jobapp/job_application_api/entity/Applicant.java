package com.example.jobapp.job_application_api.entity;
import jakarta.persistence.*;
import java.util.*;
@Entity
public class Applicant {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String password;
	private String skills;//comma saperated skills
	@ManyToMany(mappedBy = "applicants")
	private List<Job> appliedJob;
//	private List<String> skills;
//	private HashMap<String,Integer> experience;
	public Applicant() {
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Job> getAppliedJob() {
		return appliedJob;
	}
	public void setAppliedJob(List<Job> appliedJob) {
		this.appliedJob = appliedJob;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	@Override
	public String toString() {
		return "Applicant [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", skills="
				+ skills + ", appliedJob=" + appliedJob + "]";
	}
	
	
}

