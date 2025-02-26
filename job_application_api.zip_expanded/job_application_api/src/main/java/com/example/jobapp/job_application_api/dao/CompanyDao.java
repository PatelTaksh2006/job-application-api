package com.example.jobapp.job_application_api.dao;
import com.example.jobapp.job_application_api.entity.Company;
import java.util.*;
public interface CompanyDao {
	List<Company> getAllCompany();
	void updateCompany(Company theCompany);
	Company getCompanyById(int id);
	void save(Company theCompany);
	//void delete(int id);
}
