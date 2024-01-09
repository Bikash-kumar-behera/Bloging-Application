package com.pns.spring.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtUtilService {
	private static final String SECRET = "thedonkeywasmadand456youaresosad3232";

	public String generateToken(String userName) {
		Map<String, String> claims = new HashMap<>();
		return createToken(claims,userName);
	}
	
	private String createToken(Map<String, String> claims, String userName) {
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(userName)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+(1000 * 60 * 60 * 10)))
				.signWith(Keys.hmacShaKeyFor(SECRET.getBytes()), SignatureAlgorithm.HS256)
				.compact();
	}
}
