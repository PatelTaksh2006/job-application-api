package com.taksh.jobapp_api.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.taksh.jobapp_api.entity.Applicant;
import com.taksh.jobapp_api.entity.Company;
import com.taksh.jobapp_api.entity.Job;

@Repository
public interface JobRepository extends JpaRepository<Job,Integer> {
	public List<Job> findByCompany(Company company);
	public List<Job> findByTitle(String title);
	
	@Query("SELECT a FROM Applicant a JOIN a.appliedJobs j WHERE j.Jobid=:Jid")
	public List<Applicant> findApplicantByJobId(@Param("Jid") int jobId);
}
