package org.tony.spring.security.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/***
 * spring security web config
 * @author Tony
 *
 */
/***
 * WebSecurityConfig class is annotated with @EnableWebMvcSecurity to enable Spring Security’s web security support and provide the Spring MVC integration
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/***
		 * configure(HttpSecurity) method defines which URL paths should be secured and which should not. Specifically, 
		 * the "/" and "/home" paths are configured to not require any authentication. All other paths must be authenticated.
		 */
		http.authorizeRequests().antMatchers("/","/home").permitAll().
		anyRequest().authenticated().and().formLogin().
		loginPage("/login").permitAll().and().logout().permitAll();
		
	}
	
	/****
	 * it sets up an in-memory user store with a single user. That user is given a username of "user", a password of "password", and a role of "USER".
	 * @param auth
	 * @throws Exception
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth ) throws Exception {
		//setting user and password and roles
		auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
	}

}
