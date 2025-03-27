package com.taksh.jobapp_api.Service;

import java.util.List;

import com.taksh.jobapp_api.entity.Applicant;
import com.taksh.jobapp_api.entity.Company;
import com.taksh.jobapp_api.entity.Job;

public interface JobService {
	public void save(Job job);
	public void delete(int id);
	public Job findByid(int id);
	public List<Job> getJobsByCompany(Company company);
	public List<Job> getJobsByTitle(String title);
	public List<Applicant> getApplicantsByJobId(int jobId);
}
