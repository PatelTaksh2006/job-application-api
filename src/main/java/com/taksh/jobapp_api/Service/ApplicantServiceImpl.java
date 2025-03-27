package com.taksh.jobapp_api.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taksh.jobapp_api.Repository.ApplicantDao;
import com.taksh.jobapp_api.entity.Applicant;
import com.taksh.jobapp_api.entity.Job;

import jakarta.transaction.Transactional;

@Service
public class ApplicantServiceImpl implements ApplicantService {
	private ApplicantDao applicantdao;
	private UserService userService;
	
	@Autowired
	public ApplicantServiceImpl(ApplicantDao theApplicantDao,UserService userService)
	{
		this.applicantdao=theApplicantDao;
		this.userService=userService;
	}
	@Override
	public Applicant findById(int id) {
		// TODO Auto-generated method stub
		return applicantdao.findById(id);
	}

	@Override
	@Transactional
	public void save(Applicant applicant) {
		// TODO Auto-generated method stub
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


}
