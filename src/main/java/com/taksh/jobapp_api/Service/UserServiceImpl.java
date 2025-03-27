package com.taksh.jobapp_api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService {
	private UserDetailsManager jdbcUserDetailsManager;
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public UserServiceImpl(UserDetailsManager jdbcUserDetailsManager,PasswordEncoder passwordEncoder) {
		this.jdbcUserDetailsManager = jdbcUserDetailsManager;
		this.passwordEncoder = passwordEncoder;
	}


	@Override
	public void registerUser(String username, String password, String role) {
		// TODO Auto-generated method stub
		String encodedPassword = passwordEncoder.encode(password);

        UserDetails user = User.withUsername(username)
                .password(encodedPassword)
                .roles(role) 
                .build();


        jdbcUserDetailsManager.createUser(user);
	}

}
