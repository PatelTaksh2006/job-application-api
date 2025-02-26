package com.example.jobapp.job_application_api.service;
import java.util.List;
import com.example.jobapp.job_application_api.entity.Applicant;

public interface ApplicantService {
	List<Applicant> getAllApplicant();
	Applicant getApplicantById(int id);
	void updateApplicant(Applicant applicant);
	void saveApplicant(Applicant applicant);
	//void deleteApplicant(int id);
}
