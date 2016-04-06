package org.tont.spring.manager.transactions.example;

import javax.sql.DataSource;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;


/***
 * create an application
 * @author Tony
 *
 */
@SpringBootApplication
public class Application {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	@Bean
	BookService bookService(){
		return new BookService();
	}
	
	@Bean
	JdbcTemplate jdbcTemplate(DataSource dataSource){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		log.info("Create Tables");
		jdbcTemplate.execute("drop table BOOKINGS if exists");
		jdbcTemplate.execute("create table BOOKINGS(id serial,FIRST_NAME varchar(5) NOT NULL)");
		return jdbcTemplate;
	}
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
		BookService bookService = applicationContext.getBean(BookService.class);
		bookService.book("Tony","Bob","Smith");
		Assert.assertEquals("First book should work with no problem", 3,bookService.findAllBookings().size());
		
		//chars so long for "SuSans"
		try{
			bookService.book("Chirs","SuSans");
		}catch(RuntimeException e){
			log.info("v--- The following exception is expect because 'Samuel' is too big for the DB ---v");
			log.error(e.getMessage());
		}
		
		for (String person : bookService.findAllBookings()) {
			log.info("You shouldn't see Chris or SuSans. SuSans violated DB constraints, and Chris was rolled back in the same TX");
		}
		
		Assert.assertEquals("'Samuel' should have triggered a rollback", 3,
				bookService.findAllBookings().size());
		//not null
		try {
			bookService.book("Buddy", null);
		}
		catch (RuntimeException e) {
			log.info("v--- The following exception is expect because null is not valid for the DB ---v");
			log.error(e.getMessage());
		}
		
		for (String person : bookService.findAllBookings()) {
			log.info("So far, " + person + " is booked.");
		}
		log.info("You shouldn't see Buddy or null. null violated DB constraints, and Buddy was rolled back in the same TX");
		Assert.assertEquals("'null' should have triggered a rollback", 3, bookService
				.findAllBookings().size());
	}

}
