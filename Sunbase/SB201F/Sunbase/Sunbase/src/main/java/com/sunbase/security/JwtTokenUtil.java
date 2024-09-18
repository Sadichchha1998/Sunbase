package com.sunbase.security;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenUtil {
 private String secret = "jwtsecret";

 public String generateToken(UserDetails userDetails) {
     Map<String, Object> claims = new HashMap<>();
     return doGenerateToken(claims, userDetails.getUsername());
 }



 private String doGenerateToken(Map<String, Object> claims, String username) {
	// TODO Auto-generated method stub
	return null;
}



private Boolean isTokenExpired(String token) {
     return extractExpiration(token).before(new Date());
 }

 private Date extractExpiration(String token) {
	// TODO Auto-generated method stub
	return null;
}



public Boolean validateToken(String token, UserDetails userDetails) {
     final String username = extractUsername(token);
     return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
 }



String extractUsername(String token) {
	// TODO Auto-generated method stub
	return null;
}
}
