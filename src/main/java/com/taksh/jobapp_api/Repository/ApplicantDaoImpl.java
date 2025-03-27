package com.taksh.jobapp_api.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.taksh.jobapp_api.entity.Applicant;
import com.taksh.jobapp_api.entity.Job;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class ApplicantDaoImpl implements ApplicantDao {
	private EntityManager entityManager;
	
	@Autowired
	public ApplicantDaoImpl(EntityManager theEntityManager)
	{
		this.entityManager=theEntityManager;
	}
	
	@Override
	public Applicant findById(int id) {
		// TODO Auto-generated method stub
		Applicant applicant = entityManager.find(Applicant.class, id) ; 
		return applicant;
	}

	@Override
	@Transactional
	public void save(Applicant applicant) {
		// TODO Auto-generated method stub
		entityManager.merge(applicant);
	}

	@Override
	
	public void delete(int id) {
		Applicant applicant=entityManager.find(Applicant.class, id);
		entityManager.remove(applicant);
		// TODO Auto-generated method stub
	}
	
	public List<Job> findJobsAppliedByApplicant(int id)
	{
		String query="SELECT j FROM Applicant a JOIN a.appliedJobs j WHERE a.Applicantid=:id";
		TypedQuery<Job> appliedJobsList=entityManager.createQuery(query,Job.class);
		appliedJobsList.setParameter("id", id);
		return appliedJobsList.getResultList();
	}

}
