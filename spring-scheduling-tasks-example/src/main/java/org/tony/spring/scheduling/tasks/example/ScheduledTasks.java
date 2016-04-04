package org.tony.spring.scheduling.tasks.example;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/*****
 * create a scheduled tasks
 * @author Tony
 *
 */
@Component
public class ScheduledTasks {
	
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");
	
	//Scheduled annotation defines when a particular method runs
	@Scheduled(fixedRate = 5000)
	public void reportCurrentTime(){
		System.out.println("The time is now " + DATE_FORMAT.format(new Date()));
	}
	

}
