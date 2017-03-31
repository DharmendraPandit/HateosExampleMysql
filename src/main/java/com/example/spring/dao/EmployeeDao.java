package com.example.spring.dao;

import java.util.List;

import com.example.spring.bean.Employee;

public interface EmployeeDao {
	public List<Employee> getEmployeeList();
	public Employee getEmployee(String id);
}
