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

import com.taksh.jobapp_api.Service.JobService;
import com.taksh.jobapp_api.entity.Applicant;
import com.taksh.jobapp_api.entity.Company;
import com.taksh.jobapp_api.entity.Job;

@RestController
@RequestMapping("/api/jobs")
public class JobRestController {
	private JobService jobService;
	
	@Autowired
	public JobRestController(JobService theJobService)
	{
		this.jobService=theJobService;
	}
	@GetMapping("/job/{id}")
	public Job findJobByid(@PathVariable int id)
	{
		Job job=jobService.findByid(id);
		if(job==null)
			throw new RuntimeException("Job not found");
		return job;
	}
	@GetMapping("/jobTitle/{job_title}")
	public List<Job> findJobBytitle(@PathVariable String job_title)
	{
		return jobService.getJobsByTitle(job_title);
	}
	
	@GetMapping("/jobCompany/apl/{name}")
	public List<Job> findJobByCompanyNameForApplicant(@PathVariable String name)
	{
		List<Job> jobs=jobService.getJobsByCompanyName(name);
		for(int i=0;i<jobs.size();i++)
		{
			jobs.get(i).setApplicant_List(null);
		}
		return jobs;
	}
	
	@GetMapping("/jobCompany/comp/{name}")
	public List<Job> findJobByCompanyNameForCompany(@PathVariable String name)
	{
		return jobService.getJobsByCompanyName(name);
	}
	@GetMapping("/jobApplicants/{id}")
	public List<Applicant> findAllAppliedApplicant(@PathVariable int id)
	{
		return jobService.getApplicantsByJobId(id);
	}
	
	@PostMapping("/registerJob")
	public Job createJob(@RequestBody Job job)
	{
		System.out.println("works");
		job.setJobid(0);
		jobService.save(job);
		System.out.println("good");
		return job;
	}
	
	@PutMapping("/job")
	public Job updateJob(@RequestBody Job job)
	{
		jobService.save(job);
		return job;
	}
	
	@DeleteMapping("/job/{id}")
	public String deleteJob(@PathVariable int id)
	{
		Job job=jobService.findByid(id);
		if(job==null)
			return "Job not found";
		jobService.delete(id);
		return "Job deleted";
	}
}
