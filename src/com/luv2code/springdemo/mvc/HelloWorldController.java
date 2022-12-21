package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("hello")
public class HelloWorldController {

	// Need a controller method to show the initial HTML form
	@RequestMapping("/showForm")
	public String showForm( ) {
		return "helloworld-form";
	} 
	
	// Need a controller method to process the form
	@RequestMapping("/processForm")
	public String processForm () {
		return "helloworld";
	}
	
	
	
	// New a controller method to read form data and
	// add data to the model
	
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		// Read the request parameter form the html form
		String theName = request.getParameter("studentName");
		
		// Create the message
		
		String result = "Yo! " +  theName.toUpperCase();
		
		// Add message to the model
		
		model.addAttribute("message",result);
		
		return "helloworld";
		
		
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
		
		
		// Create the message
		
		String result = "Hey My Friend from another planet! " +  theName.toUpperCase();
		
		// Add message to the model
		
		model.addAttribute("message",result);
		
		return "helloworld";
		
		
	}
	
	
}
