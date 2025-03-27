package com.taksh.jobapp_api.Security;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;

@Configuration
public class JobApiSecurityConfig {
//	private JDBCUserManager jdbcUserManager;
	
	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource)
	{
		return new JdbcUserDetailsManager(dataSource);
	}
	
	@Bean
	public DefaultSecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(configurer->
		configurer
			.requestMatchers(HttpMethod.POST,"/api/applicants/applicant").anonymous() //done by only unauthorized user
			.requestMatchers(HttpMethod.GET,"/api/applicants/**").hasRole("APPLICANT")
			
			.requestMatchers(HttpMethod.PUT,"/api/applicants/**").hasRole("APPLICANT")
//			.requestMatchers(HttpMethod.DELETE,"/api/applicants/**").hasRole("APPLICANT")
			
			
			.requestMatchers(HttpMethod.GET,"/api/jobs/job").hasRole("COMPANY")
			.requestMatchers(HttpMethod.GET,"/api/jobs/jobTitle").hasRole("APPLICANT")
			.requestMatchers(HttpMethod.GET,"/api/jobs/jobCompany").hasRole("APPLICANT")
			.requestMatchers(HttpMethod.GET,"/api/jobs/jobApplicants").hasRole("COMPANY")
			.requestMatchers(HttpMethod.POST,"/api/jobs/job").anonymous()  //done by only unauthorized user
			.requestMatchers(HttpMethod.PUT,"/api/jobs/job").hasRole("COMPANY")
			.requestMatchers(HttpMethod.DELETE,"/api/jobs/job").hasRole("COMPANY")
			
			
			.requestMatchers(HttpMethod.GET,"/api/companies/**").hasRole("COMPANY")
			.requestMatchers(HttpMethod.POST,"/api/companies/**").hasRole("COMPANY")
			.requestMatchers(HttpMethod.PUT,"/api/companies/**").hasRole("COMPANY")			
				);
		http.csrf(csrf->csrf.disable());
//	    http.anonymous(Customizer.withDefaults());
		http.httpBasic(Customizer.withDefaults());

		return http.build();
		
	}
}
