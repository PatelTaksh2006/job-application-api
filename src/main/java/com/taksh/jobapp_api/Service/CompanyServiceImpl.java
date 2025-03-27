package com.taksh.jobapp_api.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taksh.jobapp_api.Repository.CompanyRepository;
import com.taksh.jobapp_api.entity.Company;

import jakarta.transaction.Transactional;

@Service
public class CompanyServiceImpl implements CompanyService {
	private CompanyRepository companyRepository;
	private UserService userService;
	
	@Autowired
	public CompanyServiceImpl(CompanyRepository companyRepository,UserService userService) {
		this.companyRepository = companyRepository;
		this.userService=userService;
	}

	@Override
	@Transactional
	public void save(Company company) {
		// TODO Auto-generated method stub
		userService.registerUser(company.getEmail(), company.getPassword(), "COMPANY");
		companyRepository.save(company);
	}

	@Override
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		companyRepository.deleteById(id);
	}

	@Override
	public Company getByid(int id) {
		// TODO Auto-generated method stub
		Optional<Company> temp_company=companyRepository.findById(id);
		if(temp_company.isPresent())
		{
			return temp_company.get();
		}
		return null;
	}

}
