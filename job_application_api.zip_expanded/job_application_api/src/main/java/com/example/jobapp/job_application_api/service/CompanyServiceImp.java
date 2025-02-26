package com.example.jobapp.job_application_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.example.jobapp.job_application_api.dao.CompanyDao;
import com.example.jobapp.job_application_api.entity.Company;

public class CompanyServiceImp implements CompanyService {
	@Qualifier("CompanyDaoImp")
	private CompanyDao companyDao;
	
	@Autowired
	public CompanyServiceImp(CompanyDao theCompanyDao)
	{
		this.companyDao=theCompanyDao;
	}
	@Override
	public List<Company> getAllCompany() {
		// TODO Auto-generated method stub
		return companyDao.getAllCompany();
	}

	@Override
	public void updateCompany(Company theCompany) {
		// TODO Auto-generated method stub
		companyDao.updateCompany(theCompany);

	}

	@Override
	public Company getCompanyById(int id) {
		// TODO Auto-generated method stub
		return companyDao.getCompanyById(id);
	}

	@Override
	public void save(Company theCompany) {
		// TODO Auto-generated method stub
		companyDao.save(theCompany);
	}

}
