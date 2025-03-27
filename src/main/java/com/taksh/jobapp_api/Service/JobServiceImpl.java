package com.taksh.jobapp_api.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taksh.jobapp_api.Repository.JobRepository;
import com.taksh.jobapp_api.entity.Applicant;
import com.taksh.jobapp_api.entity.Company;
import com.taksh.jobapp_api.entity.Job;

import jakarta.transaction.Transactional;

@Service
public class JobServiceImpl implements JobService {
	private JobRepository jobRepository;
	
	@Autowired
	public JobServiceImpl(JobRepository theJobRepository)
	{
		this.jobRepository=theJobRepository;
	}
	@Override
	@Transactional
	public void save(Job job) {
		// TODO Auto-generated method stub
		jobRepository.save(job);
	}

	@Override
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		jobRepository.deleteById(id);
	}

	@Override
	public Job findByid(int id) {
		// TODO Auto-generated method stub
		Optional<Job> job_temp=jobRepository.findById(id);
		if(job_temp.isPresent())
		{
			return job_temp.get();
		}
		return null;
	}

	@Override
	public List<Job> getJobsByCompany(Company company) {
		// TODO Auto-generated method stub
		return jobRepository.findByCompany(company);
	}

	@Override
	public List<Job> getJobsByTitle(String title) {
		// TODO Auto-generated method stub
		return jobRepository.findByTitle(title);
	}

	@Override
	public List<Applicant> getApplicantsByJobId(int jobId) {
		// TODO Auto-generated method stub
		return jobRepository.findApplicantByJobId(jobId);
	}

}
