package com.example.spring;

import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeRedirectController {

	//@GetMapping("/employeeForm")
	//@RequestMapping(value="/employeeForm", method=RequestMethod.GET)
	public String getEmployeeForm(){
		System.out.println("controller");
		return "employeeForm";
	}
	
	@GetMapping("/empForm")
	public String employeeForm() {
		//model.put("time", new Date());
		ModelAndView modelAndView = new ModelAndView("employeeForm");
		System.out.println("****************************empForm controller%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		return "employeeForm";
	}
}
