package com.example.jobapp.job_application_api.dao;
import com.example.jobapp.job_application_api.entity.Company;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class CompanyDaoImp implements CompanyDao{
	private EntityManager entityManager;
	@Override
	
	public List<Company> getAllCompany()
	{
		TypedQuery<Company> theQuery=entityManager.createQuery("FROM Company",Company.class);
		return theQuery.getResultList();
	}
	
	@Override
	public Company getCompanyById(int id)
	{
		return entityManager.find(Company.class, id);
	}
	
	@Override
	@Transactional
	public void updateCompany(Company theCompany)
	{
		entityManager.merge(theCompany);
	}
	
	@Override
	@Transactional
	public void save(Company theCompany)
	{
		entityManager.persist(theCompany);
	}

}
