package com.example.jobapp.job_application_api.service;
import java.util.List;
import com.example.jobapp.job_application_api.entity.Job;

public interface JobService {
	List<Job> getAllJob();
	List<Job> getAllJobByCompany(int CompanyId);
	List<Job> getAllJobByName(String name);
	List<Job> findJobByApplicant(int id);
	void save(Job theJob);
	void update(Job theJob);
	void delete(int id);
}
