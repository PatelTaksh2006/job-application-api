package com.taksh.jobapp_api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taksh.jobapp_api.Service.ApplicantService;
import com.taksh.jobapp_api.entity.Applicant;
import com.taksh.jobapp_api.entity.Job;

@RestController
@RequestMapping("/api/aplicants")
public class ApplicantRestController {
	private ApplicantService applicantService;
	@Autowired
	public ApplicantRestController(ApplicantService theApplicantService)
	{
		this.applicantService=theApplicantService;
	}
	
	@GetMapping("/applicant/{id}")
	public Applicant getApplicantByid(@PathVariable int id)
	{
		Applicant applicant=applicantService.findById(id);
		if(applicant==null)
			throw new RuntimeException("Applicant not found");
		return applicant;
	}
	
	@GetMapping("/applicant/appliedjobs/{id}")
	public List<Job> getAlljobAppliedByApplicant(@PathVariable int id)
	{
		List<Job> jobs= applicantService.findJobsAppliedByApplicant(id);
		for(int i=0;i<jobs.size();i++)
		{
			jobs.get(i).setApplicant_List(null);
		}
		return jobs;
	}
	
	@PostMapping("/applicant")
	public Applicant createApplicant(@RequestBody Applicant theApplicant)
	{
		theApplicant.setApplicantid(0);
		applicantService.save(theApplicant);
		return theApplicant;
	}
	@PutMapping("/apply/{applicant_id}/{job_id}")
	public Applicant applyForJob(@PathVariable("applicant_id") int applicantId,@PathVariable("job_id") int jobId)
	{
		Applicant theApplicant=applicantService.applyForJob(applicantId, jobId);
		if(theApplicant==null)
		{
			throw new RuntimeException("Not applied for job please try again later");
		}
		return theApplicant;
	}
	@PutMapping("/applicant")
	public Applicant updateApplicant(@RequestBody Applicant theApplicant)
	{
		applicantService.save(theApplicant);
		return theApplicant;
	}
	
	@DeleteMapping("/applicant/{id}")
	public String deleteApplicant(@PathVariable int id)
	{
		Applicant applicant=applicantService.findById(id);
		if(applicant==null)
			return "Applicant not found";
		applicantService.delete(id);
		return "Successfully deleted";
	}
}
