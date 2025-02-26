package com.example.jobapp.job_application_api.dao;
import com.example.jobapp.job_application_api.entity.Applicant;
import jakarta.persistence.*;
import jakarta.transaction.*;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class ApplicantDaoImp implements ApplicantDao{
	private EntityManager entityManager;

	public ApplicantDaoImp(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Applicant> getAllApplicant()
	{
		TypedQuery<Applicant> theQuery=entityManager.createQuery("FROM Applicant",Applicant.class);
		return theQuery.getResultList();
	}
	
	@Override
	public Applicant getApplicantById(int id)
	{
		return entityManager.find(Applicant.class,id);
	}
	
	@Override
	@Transactional
	public void saveApplicant(Applicant applicant)
	{
		entityManager.persist(applicant);
	}
	
	@Override
	@Transactional
	public void updateApplicant(Applicant applicant)
	{
		entityManager.merge(applicant);
	}
}

