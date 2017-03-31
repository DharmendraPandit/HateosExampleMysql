package com.example.spring;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.bean.Employee;
import com.example.spring.service.EmployeeService;

@RestController
public class EmployeeController {

	//private static final String TEMPLATE = "Hello, %s!";
	
	@Autowired
	EmployeeService employeeService;
	
	//@GetMapping("/getEmp")
	@RequestMapping("/empList")
	public HttpEntity<List<Employee>> getEmployeeList(){
		
		List<Employee> empList = employeeService.getEmployeeList();
		for(Employee emp: empList){
			emp.add(linkTo(methodOn(EmployeeController.class).getEmployeeList()).withSelfRel());
		}
		return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);
	}
	
	@RequestMapping(value="/emp/{id}", method=RequestMethod.GET)
	public HttpEntity<Employee> getEmployee(@PathVariable String id){
	
		Employee emp = employeeService.getEmployee(id);
		emp.add(linkTo(methodOn(EmployeeController.class).getEmployee(id)).withSelfRel());
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
	
	@RequestMapping(value="/employeeSave")
	public String employeeSave(){
		
		return "";
	}
	
}
