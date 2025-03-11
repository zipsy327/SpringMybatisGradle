package data.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SawonController {
	@GetMapping({"/","/list"})
	public String sawonList()
	{
		return "sawon/sawonlist";		
	}
}
