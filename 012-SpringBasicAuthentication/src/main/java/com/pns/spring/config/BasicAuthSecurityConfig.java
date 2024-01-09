package com.pns.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class BasicAuthSecurityConfig {
	@Bean
	PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	UserDetailsService getUserDetailsService() {
		UserDetails admin = User.builder().username("admin").password(getPasswordEncoder().encode("admin")).roles("ADMIN").build();
		UserDetails user = User.builder().username("user").password(getPasswordEncoder().encode("user")).roles("USER").build();
		
		return new InMemoryUserDetailsManager(admin,user);
	}
}
