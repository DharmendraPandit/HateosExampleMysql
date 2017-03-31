package com.example.spring.bean;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.tree.TreePath;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.jdbc.core.RowMapper;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee extends ResourceSupport implements Serializable, RowMapper<Employee> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3724492758052206691L;

	@JsonCreator
	public Employee(@JsonProperty("employeeId") String employeeId, @JsonProperty("employeeName") String employeeName,
			@JsonProperty("employeeAge") int employeeAge, @JsonProperty("employeeOrg") String employeeOrg) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeAge = employeeAge;
		this.employeeOrg = employeeOrg;
	}
	
	public Employee(){}

	private String employeeId = "";
	private String employeeName = "";
	private int employeeAge;
	private String employeeOrg = "";

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getEmployeeAge() {
		return employeeAge;
	}

	public void setEmployeeAge(int employeeAge) {
		this.employeeAge = employeeAge;
	}

	public String getEmployeeOrg() {
		return employeeOrg;
	}

	public void setEmployeeOrg(String employeeOrg) {
		this.employeeOrg = employeeOrg;
	}

	@Override
	public String toString(){
		return String.format("Employee[employeeId='%s', employeeName='%s', employeeAge=%d, employeeOrg='%s']", employeeId, employeeName, employeeAge, employeeOrg);
	}

	@Override
	public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
		
		return new Employee(rs.getString("emp_id"), rs.getString("emp_name"), rs.getInt("emp_age"), rs.getString("org"));
	}
}
