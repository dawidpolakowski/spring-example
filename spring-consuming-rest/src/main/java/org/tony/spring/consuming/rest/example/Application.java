package org.tony.spring.consuming.rest.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

/****
 * 启动spring boot的框架
 * @author Tony
 *
 */
@SpringBootApplication
public class Application implements CommandLineRunner{
	//日志
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Override
	public void run(String... args) throws Exception {
		//调用resy的URL
		RestTemplate restTemplate = new RestTemplate();
		Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
		log.info(quote.toString());
	}

}
