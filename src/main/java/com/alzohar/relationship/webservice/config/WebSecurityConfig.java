package com.alzohar.relationship.webservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/api/products/**").permitAll()
		.antMatchers("/api/product/**").hasRole("USER")
		.antMatchers("/api/orders/**").hasRole("ADMIN")
		.antMatchers("/api/users/**").hasRole("USER")
		.antMatchers("/api/employees/**").hasRole("VENDOR")
		.antMatchers("/api/employee/**").permitAll()
		.anyRequest().authenticated();
		http.formLogin();
		http.httpBasic();
		http.csrf().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("khan")
		.password("khan@123")
		.roles("USER")
		.and()
		.withUser("sheikh")
		.password("sheikh@123")
		.roles("VENDOR")
		.and()
		.withUser("admin")
		.password("admin@123")
		.roles("ADMIN");
	}
	

	@Bean
	protected PasswordEncoder getPasswordEnconder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
