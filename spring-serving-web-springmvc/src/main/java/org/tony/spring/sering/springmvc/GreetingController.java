package org.tony.spring.sering.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/***
 * create a controller
 * @author Tony
 * @Controller 
 */
@Controller
public class GreetingController {
	/****
	 * The @RequestMapping annotation ensures that HTTP requests to /greeting are mapped to the greeting() method.
	 * NOTE:The above example does not specify GET vs. PUT, POST, and so forth, because @RequestMapping maps all HTTP operations by default. 
	 * Use @RequestMapping(method=GET) to narrow this mapping.
	 * @param name
	 * @param model
	 * @return
	 */
	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value="name",defaultValue="world",required=false)String name,Model model){
		model.addAttribute("name",name);
		return "greeting";
	}

}
