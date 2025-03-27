package com.taksh.jobapp_api.Repository;

import java.util.List;

import com.taksh.jobapp_api.entity.Applicant;
import com.taksh.jobapp_api.entity.Job;

public interface ApplicantDao{
	public Applicant findById(int id);
	public void save(Applicant applicant);
	public void delete(int id);
	public List<Job> findJobsAppliedByApplicant(int id);
}
