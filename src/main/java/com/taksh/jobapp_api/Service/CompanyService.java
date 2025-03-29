package com.taksh.jobapp_api.Service;

import com.taksh.jobapp_api.entity.Company;

public interface CompanyService {
	public void save(Company company,boolean isNew);
	public void delete(int id);
	public Company getByid(int id);
}
