package com.vince.boot.demo.webapp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
//http://docs.spring.io/spring-boot/docs/current/reference/html/howto-security.html
//Switch off the Spring Boot security configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private static final String QUERY_ON_USER_TABLE = "select username, password, true from d_user_app where username=?";
	private static final String QUERY_ON_ROLE_TABLE = "select u.username, r.role_code from d_role_user r, d_user_app u where u.username = ? and u.fk_id_role_user = r.id";

	@Autowired
	private AccessDeniedHandler accessDeniedHandler;
	
	@Autowired
	DataSource dataSource;

	// roles admin allow to access /admin/**
	// roles user allow to access /user/**
	// custom 403 access denied handler
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/", "/indexFreelancer", "/indexAdmin", "/home", "/about", "/jquery/**", "/bootstrap/**", "/datepicker/**", "/css/**", "/freelancer/**", "/adminBoot/**").permitAll()
		.antMatchers("/homeProtected/**", "/Manage_Clients", "/Manage_Orders" ).hasAnyRole("ADMIN","USER")
		.antMatchers("/admin/**", "/Manage_Users/*").hasAnyRole("ADMIN")
		.antMatchers("/user/**").hasAnyRole("USER")
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/login").defaultSuccessUrl("/homeProtected", true).permitAll()
		.and()
		.logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedHandler(accessDeniedHandler);
	}
	

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(QUERY_ON_USER_TABLE)
		.authoritiesByUsernameQuery(QUERY_ON_ROLE_TABLE)
		.passwordEncoder(NoOpPasswordEncoder.getInstance());
	}


}
