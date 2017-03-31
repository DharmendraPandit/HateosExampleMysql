package com.example.spring.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.spring.bean.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Employee> getEmployeeList() {
		String query = "SELECT emp_id,emp_name,emp_age,org from employee";
		List<Employee> empList = new ArrayList<>();
		//jdbcTemplate.queryForList(query, (resultSet, i) -> { new Employee(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3),resultSet.getInt(3)); });
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
		for (Map<String, Object> row : rows) {
			Employee emp = new Employee(row.get("EMP_ID").toString(), row.get("EMP_NAME").toString(), Integer.parseInt(row.get("EMP_AGE").toString()), row.get("ORG").toString());
			empList.add(emp);
		}
		
		return empList;
	}

	@Override
	public Employee getEmployee(String id) {
		String query = "select emp_id, emp_name, emp_age, org from employee where emp_id= ?";
		return jdbcTemplate.queryForObject(query, new Object[]{id}, new Employee());
	}

}
