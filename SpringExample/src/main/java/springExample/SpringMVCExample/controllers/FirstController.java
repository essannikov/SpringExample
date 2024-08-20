package springExample.SpringMVCExample.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/first")
public class FirstController {
	
	@GetMapping("/hello")
	public String helloPage(@RequestParam("name") String name,
			  				@RequestParam(value = "surname", required = false) String surname,
			  				Model model) {
		//System.out.println("Hello, " + name + " " + surname);
		model.addAttribute("message", "Hello, " + name + " " + surname);
		
		return "first/hello";
	}
	
	@GetMapping("/goodbye")
	public String goodByePage(HttpServletRequest request) {
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		
		System.out.println("Goodbye, " + name + " " + surname);
		
		return "first/goodbye";
	}
	
}
