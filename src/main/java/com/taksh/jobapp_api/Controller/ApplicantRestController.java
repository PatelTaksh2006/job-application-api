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
		return applicantService.findJobsAppliedByApplicant(id);
	}
	
	@PostMapping("/register")
	public Applicant createApplicant(@RequestBody Applicant theApplicant)
	{
		theApplicant.setApplicantid(0);
		applicantService.save(theApplicant);
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
