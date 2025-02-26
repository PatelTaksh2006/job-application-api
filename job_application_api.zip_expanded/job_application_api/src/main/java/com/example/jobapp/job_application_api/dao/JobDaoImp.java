package com.example.jobapp.job_application_api.dao;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import com.example.jobapp.job_application_api.entity.Job;
import java.util.*;
@Repository
public class JobDaoImp implements JobDao{
	private EntityManager entityManager;
	
	@Override
	public List<Job> getAllJob()
	{
		TypedQuery<Job> theQuery=entityManager.createQuery("FROM Job",Job.class);
		return theQuery.getResultList();
	}
	
	
	@Override
	public List<Job> getAllJobByCompany(int companyId)
	{
		TypedQuery<Job> theQuery=entityManager.createQuery("SELECT j FROM Job j WHERE j.company.id= :id", Job.class);
		theQuery.setParameter("id", companyId);
		return theQuery.getResultList();
	}


	@Override
	public List<Job> getAllJobByName(String name) {
		// TODO Auto-generated method stub
		TypedQuery<Job> theQuery=entityManager.createQuery("SELECT j FROM Job j WHERE j.title= :name", Job.class);
		theQuery.setParameter("name", name);
		return theQuery.getResultList();
	}


	@Override
	public void save(Job theJob) {
		entityManager.persist(theJob);
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update(Job theJob) {
		// TODO Auto-generated method stub
		entityManager.merge(theJob);
	}


	@Override
	public List<Job> findJobByApplicant(int id) {
		// TODO Auto-generated method stub
		TypedQuery<Job> theQuery=entityManager.createQuery("SELECT j from Job j JOIN j.applicants a WHERE a.id=:applicant_id",Job.class);
		theQuery.setParameter("applicant_id", id);
		return theQuery.getResultList();
	}


	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Job theJob=entityManager.find(Job.class, id);
		entityManager.remove(theJob);
		
	}
	
	
}
