package com.example.jobapp.job_application_api.dao;
import com.example.jobapp.job_application_api.entity.Job;
import java.util.*;
public interface JobDao {
	List<Job> getAllJob();
	List<Job> getAllJobByCompany(int CompanyId);
	List<Job> getAllJobByName(String name);
	List<Job> findJobByApplicant(int id);
	void save(Job theJob);
	void update(Job theJob);
}
