package com.finalProject.project.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.finalProject.project.dao.UsersCRUDRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//			.antMatchers("/user/register")
//			.permitAll();
		
		http.authorizeRequests()
			.antMatchers("/user/register")
			.permitAll()
	        .antMatchers("/user/login")
	        .permitAll()
	    .antMatchers("/**")
	        .hasAnyRole("User")
	    .and()
	        .formLogin()
	        .loginPage("/user/login")
	        .usernameParameter("username")
	        .passwordParameter("password")
	        .defaultSuccessUrl("/user/home")
	        .failureUrl("/user/login")
	        .permitAll()
	    .and()
	        .logout()
	        .logoutUrl("/user/logout")
	        .logoutSuccessUrl("/user/login")
	        .invalidateHttpSession(true)
	        .permitAll()
        .and()
            .csrf()
            .disable()
            ;
	}

	@Autowired
	  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// !important {noop}
	    auth.inMemoryAuthentication().withUser("test").password("{noop}test").roles("User");
		
//		auth.jdbcAuthentication()
//	      .dataSource()
//	      .withDefaultSchema()
//	      .withUser(User.withUsername("test"));
//		
	  }
	

	
//	@Bean
//	@Override
//	public UserDetailsService userDetailsService() {
//		UserDetails user =
//			 User.withDefaultPasswordEncoder()
//			 	.username("username")
//				.password("password")
//				.roles("User")
//				.build();
//
//		return new InMemoryUserDetailsManager(user);
//	}
}