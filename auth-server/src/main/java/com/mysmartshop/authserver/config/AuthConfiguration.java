package com.mysmartshop.authserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.mysmartshop.authserver.repository.UserRepo;
import com.mysmartshop.authserver.util.AuthenticationFilter;

@Configuration
public class AuthConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserRepo repo;
	
	@Autowired 
	UserDetailsService userDetailsService;
	
	
	@Autowired
	private AuthenticationFilter filter;

	
	// Authentication 
	// Creating in-memory users with roles

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//		.withUser("Ebin").password("0987").roles("ADMIN")
//		.and()
//		.withUser("Divya").password("divya123").roles("USER")
//		;
//	}
	// Authentication 
		// Creating users from database
		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			
			auth.userDetailsService(userDetailsService);
			
		}
		
		// Authorization
		// Role based API Level
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable().
				authorizeHttpRequests()
				.antMatchers("/admin/**")
				.hasRole("ADMIN")
				.antMatchers("/user/**")
				.hasAnyRole("USER","ADMIN")
				.antMatchers("/**")
				.permitAll()
				.anyRequest()
				.authenticated()
				.and()
				.exceptionHandling()
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
				
				http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
			
//				.and()
//				.formLogin() // to add a default login form
//				.and()
//				.httpBasic();
				
		}
		
		
		
//		@Bean
//		PasswordEncoder passwordEncoder() {
//			return NoOpPasswordEncoder.getInstance();
//		}
		
		@Bean
		PasswordEncoder getPasswordEncoder() {
			return new BCryptPasswordEncoder();
		}
		
		@Bean
		public AuthenticationManager getAuthenticationManager() throws Exception {
			return super.authenticationManager();
		}

}
