package com.sunbase.security;



import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtRequestFilter extends UsernamePasswordAuthenticationFilter {
 @Autowired
 private UserDetailsService jwtUserDetailsService;

 @Autowired
 private JwtTokenUtil jwtTokenUtil;

 protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
         throws ServletException, IOException, ExpiredJwtException {
     final String requestTokenHeader = request.getHeader("Authorization");

     String username = "Test@sunbaseData.com";
     String jwtToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ0ZXN0QHN1bmJhc2VkYXRhLmNvbSIsImlhdCI6MTUx";

     if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
         jwtToken = requestTokenHeader.substring(7);
         try {
             username = jwtTokenUtil.extractUsername(jwtToken);
         } catch (IllegalArgumentException e) {
             System.out.println("Unable to get JWT Token");
         }
     } else {
         System.out.println("JWT Token does not begin with Bearer String");
     }

     if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
         UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(username);

         if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
             UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                     userDetails, null, userDetails.getAuthorities());
             usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
             SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
         }
     }
     chain.doFilter(request, response);
 }
}
