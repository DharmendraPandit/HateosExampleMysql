package com.example.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.bean.Employee;
import com.example.spring.dao.EmployeeDao;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	
	public List<Employee> getEmployeeList(){
		return employeeDao.getEmployeeList();
	}
	
	public Employee getEmployee(String id){
		return employeeDao.getEmployee(id);
	}
}
