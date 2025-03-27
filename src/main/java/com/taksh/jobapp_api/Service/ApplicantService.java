package com.taksh.jobapp_api.Service;

import java.util.List;

import com.taksh.jobapp_api.entity.Applicant;
import com.taksh.jobapp_api.entity.Job;

public interface ApplicantService {
	public Applicant findById(int id);
	public void save(Applicant applicant);
	public void delete(int id);
	public List<Job> findJobsAppliedByApplicant(int id);
}
