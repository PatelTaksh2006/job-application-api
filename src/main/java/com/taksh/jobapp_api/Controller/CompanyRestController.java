package com.taksh.jobapp_api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taksh.jobapp_api.Service.CompanyService;
import com.taksh.jobapp_api.entity.Company;

@RestController
@RequestMapping("/api/companies")
public class CompanyRestController {
    
    private final CompanyService companyService;

    @Autowired
    public CompanyRestController(CompanyService theCompanyService) {
        this.companyService = theCompanyService;
    }

    
    @GetMapping("/company/{id}")
    public Company getCompanyById(@PathVariable int id) {
        Company company = companyService.getByid(id);
        if (company == null)
            throw new RuntimeException("Company not found");
        return company;
    }

    
    @PostMapping("/company")
    public Company createCompany(@RequestBody Company theCompany) {
        theCompany.setCompanyid(0); // Ensure it's a new company
        companyService.save(theCompany,true);
        return theCompany;
    }

    
    @PutMapping("/company")
    public Company updateCompany(@RequestBody Company theCompany) {
        companyService.save(theCompany,false);
        return theCompany;
    }

    
    @DeleteMapping("/company/{id}")
    public String deleteCompany(@PathVariable int id) {
        Company company = companyService.getByid(id);
        if (company == null)
            return "Company not found";
        
        companyService.delete(id);
        return "Successfully deleted";
    }
}