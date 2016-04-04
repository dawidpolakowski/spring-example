package org.tony.spring.scheduling.tasks.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/***
 * Enable Scheduling
 * @author Tony
 *
 */
@SpringBootApplication
@EnableScheduling
public class Application {
	
	public static void main(String[] args) {
		
		SpringApplication.run(Application.class);
		
	}

}
