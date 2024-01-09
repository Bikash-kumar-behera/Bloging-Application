package com.pns.spring.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class BasicAuthPathFilter {
	@Bean
	SecurityFilterChain getAdminFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authz -> authz
        		.requestMatchers("/auth/home").fullyAuthenticated()
                .requestMatchers("/auth/admin").hasRole("ADMIN")
                .requestMatchers("/auth/user").hasAnyRole("USER","ADMIN")).httpBasic(Customizer.withDefaults());
        return http.build();
	}	  	 
}
