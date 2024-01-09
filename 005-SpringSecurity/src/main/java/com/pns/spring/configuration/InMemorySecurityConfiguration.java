package com.pns.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class InMemorySecurityConfiguration{

    @Bean
    UserDetailsService userDetailsService() {
    	UserDetails user = User.builder().username("user").password(passwordEncoder().encode("user")).roles("USER").build();
    	UserDetails admin = User.builder().username("admin").password(passwordEncoder().encode("admin")).roles("ADMIN").build();
    	UserDetails manager = User.builder().username("manager").password(passwordEncoder().encode("manager")).roles("MANAGER").build();
    	return new InMemoryUserDetailsManager(user,manager,admin);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }
}
