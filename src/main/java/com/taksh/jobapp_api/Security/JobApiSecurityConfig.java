package com.taksh.jobapp_api.Security;
import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class JobApiSecurityConfig {
//	private JDBCUserManager jdbcUserManager;
	
	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource)
	{
		return new JdbcUserDetailsManager(dataSource);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public DefaultSecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(configurer->
		configurer
			.requestMatchers(HttpMethod.POST,"/api/aplicants/applicant").anonymous() //done by only unauthorized user
			.requestMatchers(HttpMethod.GET,"/api/aplicants/**").hasRole("APPLICANT")
			.requestMatchers(HttpMethod.PUT,"/api/aplicants/apply/*/*").hasRole("APPLICANT")
			.requestMatchers(HttpMethod.PUT,"/api/aplicants/applicant").hasRole("APPLICANT")
//			.requestMatchers(HttpMethod.DELETE,"/api/applicants/**").hasRole("APPLICANT")
			
	
			.requestMatchers(HttpMethod.GET,"/api/jobs/job/**").hasRole("COMPANY")
			.requestMatchers(HttpMethod.GET,"/api/jobs/jobTitle/**").hasRole("APPLICANT")
			.requestMatchers(HttpMethod.GET,"/api/jobs/jobCompany/apl/**").hasRole("APPLICANT")
			.requestMatchers(HttpMethod.GET,"/api/jobs/jobCompany/comp/**").hasRole("COMPANY")
			.requestMatchers(HttpMethod.GET,"/api/jobs/jobApplicants/**").hasRole("COMPANY")
			.requestMatchers(HttpMethod.POST,"api/jobs/registerJob").hasRole("COMPANY")
			.requestMatchers(HttpMethod.PUT,"/api/jobs/job").hasRole("COMPANY")
			.requestMatchers(HttpMethod.DELETE,"/api/jobs/job/**").hasRole("COMPANY")
			
			
			.requestMatchers(HttpMethod.GET,"/api/companies/**").hasRole("COMPANY")
			.requestMatchers(HttpMethod.POST,"/api/companies/company").anonymous()  //done by only unauthorized user
			.requestMatchers(HttpMethod.PUT,"/api/companies/**").hasRole("COMPANY")			
				);
		
		  	
		
//	    http.anonymous(Customizer.withDefaults());
		http.httpBasic(Customizer.withDefaults());
		http.csrf(csrf -> csrf.disable());
		return http.build();
		
	}
}
