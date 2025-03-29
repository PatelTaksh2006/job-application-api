package com.taksh.jobapp_api.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taksh.jobapp_api.Repository.ApplicantDao;
import com.taksh.jobapp_api.Repository.JobRepository;
import com.taksh.jobapp_api.entity.Applicant;
import com.taksh.jobapp_api.entity.Job;

import jakarta.transaction.Transactional;

@Service
public class ApplicantServiceImpl implements ApplicantService {
	private ApplicantDao applicantdao;
	private JobRepository jobRepository;
	private UserService userService;
	
	@Autowired
	public ApplicantServiceImpl(ApplicantDao theApplicantDao,UserService userService,JobRepository theJobRepository)
	{
		this.applicantdao=theApplicantDao;
		this.userService=userService;
		this.jobRepository=theJobRepository;
	}
	@Override
	public Applicant findById(int id) {
		// TODO Auto-generated method stub
		return applicantdao.findById(id);
	}

	@Override
	@Transactional
	public void save(Applicant applicant,boolean isNew) {
		// TODO Auto-generated method stub
		if(isNew)
		userService.registerUser(applicant.getEmail(), applicant.getPassword(), "APPLICANT");
		applicantdao.save(applicant);
		
	}

	@Override
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		applicantdao.delete(id);
	}

	@Override
	public List<Job> findJobsAppliedByApplicant(int id) {
		// TODO Auto-generated method stub
		return applicantdao.findJobsAppliedByApplicant(id);
	}
	@Override
	@Transactional
	public Applicant applyForJob(int applicantId, int jobId) {
		// TODO Auto-generated method stub
		Applicant theApplicant=applicantdao.findById(applicantId);
		Optional<Job> theJob=jobRepository.findById(jobId);
		Job job = null;
		if(theJob.isPresent())
		{
			job=theJob.get();
			job.setApplicant_List(null);
			return applicantdao.applyForJob(theApplicant, job);
		}
		return null;
		
		
	}


}
