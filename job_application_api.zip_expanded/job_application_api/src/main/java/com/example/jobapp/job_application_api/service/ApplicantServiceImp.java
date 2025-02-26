package com.example.jobapp.job_application_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.example.jobapp.job_application_api.dao.ApplicantDao;
import com.example.jobapp.job_application_api.entity.Applicant;

public class ApplicantServiceImp implements ApplicantService {
	@Qualifier("ApplicantDaoImp")
	private ApplicantDao applicantDao;
	
	@Autowired
	public ApplicantServiceImp(ApplicantDao theApplicantDao)
	{
		this.applicantDao=theApplicantDao;
	}

	@Override
	public List<Applicant> getAllApplicant() {
		// TODO Auto-generated method stub
		return applicantDao.getAllApplicant();
	}

	@Override
	public Applicant getApplicantById(int id) {
		// TODO Auto-generated method stub
		return applicantDao.getApplicantById(id);
	}

	@Override
	public void updateApplicant(Applicant applicant) {
		// TODO Auto-generated method stub
		applicantDao.updateApplicant(applicant);
	}

	@Override
	public void saveApplicant(Applicant applicant) {
		// TODO Auto-generated method stub
		applicantDao.saveApplicant(applicant);
	}
	
	
}
