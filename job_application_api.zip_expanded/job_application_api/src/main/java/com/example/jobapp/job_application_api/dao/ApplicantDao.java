package com.example.jobapp.job_application_api.dao;
import java.util.*;
import com.example.jobapp.job_application_api.entity.Applicant;
public interface ApplicantDao {
	List<Applicant> getAllApplicant();
	Applicant getApplicantById(int id);
	void updateApplicant(Applicant applicant);
	void saveApplicant(Applicant applicant);
//	void deleteApplicant(int id);
}

