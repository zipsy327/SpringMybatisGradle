package data.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SawonController {
	@GetMapping("/")
	public String mainPage()
	{
		return "sawon/mainpage";		
	}
	
	@GetMapping({"/list"})
	public String sawonList()
	{
		return "sawon/sawonlist";		
	}
	
	@GetMapping("/form")
	public String sawonForm()
	{
		return "sawon/sawonform";		
	}
}
