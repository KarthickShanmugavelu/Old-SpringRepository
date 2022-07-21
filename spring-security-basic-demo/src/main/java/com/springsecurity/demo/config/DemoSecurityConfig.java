package com.springsecurity.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;


@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
	
	//add a reference to our security datasource
	@Autowired
	private DataSource securityDataSource;
	
	
	//DB authentcation
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//use jdbc authentcation
		auth.jdbcAuthentication().dataSource(securityDataSource);
		
		
	}
	

	/*
	 * @Override public void configure(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * 
	 * //custom security code UserBuilder users = User.withDefaultPasswordEncoder();
	 * 
	 * auth.inMemoryAuthentication().withUser(users.username("karthi").password(
	 * "vikram").roles("EMPLOYEE","ADMIN"))
	 * .withUser(users.username("naveen").password("naayagan").roles("EMPLOYEE",
	 * "MANAGER"))
	 * .withUser(users.username("keerthi").password("loosu").roles("EMPLOYEE")); }
	 */

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http.authorizeRequests()
				.antMatchers("/").permitAll() // allow public access to landing page
				.antMatchers("/employees").hasRole("EMPLOYEE")
				.antMatchers("/leaders/**").hasRole("MANAGER")
				.antMatchers("/systems/**").hasRole("ADMIN")
				.antMatchers("/css/**").permitAll()
				.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll()
			.and()
			.logout().permitAll()
			.and()
			.exceptionHandling()
				.accessDeniedPage("/access-denied");
		
	}
	
	
	
	

	
	
	
	
	
}
