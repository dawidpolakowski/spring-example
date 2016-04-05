package org.tony.spring.security.example;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/***
 * mvc config Here’s a configuration class for configuring Spring MVC in the application
 * @author Tony
 *
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter{
	
	/***
	 * addViewControllers() method (overriding the method of the same name in WebMvcConfigurerAdapter) adds four view controllers.
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		//setting view and view name
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/hello").setViewName("hello");
		registry.addViewController("/login").setViewName("login");
	}

}
