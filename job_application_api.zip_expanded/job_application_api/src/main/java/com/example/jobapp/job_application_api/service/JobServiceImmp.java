package com.example.jobapp.job_application_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;

import com.example.jobapp.job_application_api.dao.JobDao;
import com.example.jobapp.job_application_api.entity.Job;

public class JobServiceImmp implements JobService {

	@Qualifier("JobDaoImp")
	private JobDao jobDao;
	@Override
	public List<Job> getAllJob() {
		// TODO Auto-generated method stub
		return jobDao.getAllJob();
	}

	@Override
	public List<Job> getAllJobByCompany(int CompanyId) {
		// TODO Auto-generated method stub
		return jobDao.getAllJobByCompany(CompanyId);
	}

	@Override
	public List<Job> getAllJobByName(String name) {
		// TODO Auto-generated method stub
		return jobDao.getAllJobByName(name);
	}

	@Override
	public List<Job> findJobByApplicant(int id) {
		// TODO Auto-generated method stub
		return jobDao.findJobByApplicant(id);
	}

	@Override
	public void save(Job theJob) {
		// TODO Auto-generated method stub
		jobDao.save(theJob);

	}

	@Override
	public void update(Job theJob) {
		// TODO Auto-generated method stub
		jobDao.update(theJob);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		jobDao.delete(id);
	}

}
