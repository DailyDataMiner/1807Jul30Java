package com.ex.service;
//import java.human.emotion.sadness
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.dao.EmployeeDao;
import com.ex.pojos.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;


public class EmployeeService {

	private static EmployeeDao employeeDao = new EmployeeDao();
	
	
	// 1. Read the Request body (JSON), and set it to the `json` String variable
	// 2. Using the ObjectMapper, map the json into an object of type User
	// 3. Perform rest of logic that requires a User POJO
	public static Employee login(HttpServletRequest request, HttpServletResponse response) {
		ObjectMapper mapper = new ObjectMapper();
		Employee employee = null;
		try {
			employee = mapper.readValue(request.getReader(), Employee.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		Employee authorized = employeeDao.findOneEmp(employee.getUsername());
		if (employee.getPassword().equals(authorized.getPassword()))
			return employeeDao.findOneEmp(employee.getUsername());
		return null;
	}	
}

