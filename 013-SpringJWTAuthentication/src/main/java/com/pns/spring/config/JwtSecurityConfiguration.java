package com.pns.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.pns.spring.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class JwtSecurityConfiguration {
	@Autowired
	CustomUserDetailsService customUserDetailsService;
	
//	@Bean
//	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//		http.
//			authorizeHttpRequests(authz->authz
//					.requestMatchers("").hasRole("ADMIN")).httpBasic(Customizer.withDefaults());
//		return http.build();
//	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
