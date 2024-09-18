package com.sunbase.security;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig<JwtAuthenticationEntryPoint> extends WebSecurityConfigurerAdapter {
 @Autowired
 private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

 @Autowired
 private UserDetailsService jwtUserDetailsService;

 @Autowired
 private JwtRequestFilter jwtRequestFilter;

 @Autowired
 public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
     auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
 }

 @Bean
 public PasswordEncoder passwordEncoder() {
     return new BCryptPasswordEncoder();
 }



}

