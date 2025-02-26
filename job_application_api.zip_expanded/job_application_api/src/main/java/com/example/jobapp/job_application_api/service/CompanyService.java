package com.example.jobapp.job_application_api.service;
import java.util.List;
import com.example.jobapp.job_application_api.entity.Company;

public interface CompanyService {
	List<Company> getAllCompany();
	void updateCompany(Company theCompany);
	Company getCompanyById(int id);
	void save(Company theCompany);
	//void delete(int id);
}
