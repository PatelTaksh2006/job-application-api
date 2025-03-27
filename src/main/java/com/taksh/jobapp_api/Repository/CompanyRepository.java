package com.taksh.jobapp_api.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taksh.jobapp_api.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer> {
	
}
