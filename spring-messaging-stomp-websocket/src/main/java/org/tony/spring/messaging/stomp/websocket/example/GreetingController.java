package org.tony.spring.messaging.stomp.websocket.example;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {
	
	@MessageMapping("/hello")    //The @MessageMapping annotation ensures that if a message is sent to destination "/hello" then the greeting() method is called.
	@SendTo("/topic/greetings")  //The return value is broadcast to all subscribers to "/topic/greetings" as specified in the @SendTo annotation.
	public Greeting greeting(HelloMessage helloMessage) throws InterruptedException{
		Thread.sleep(3000);
		return new Greeting("Hello, " + helloMessage.getName() + " !");
	}
}
