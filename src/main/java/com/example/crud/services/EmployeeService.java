package com.example.crud.services;

import java.util.List;

import com.example.crud.payload.EmployeeDto;


public interface EmployeeService {

	EmployeeDto createNewEmployee(EmployeeDto employee);
	
	EmployeeDto getEmployeeById(Integer id);
	
	List<EmployeeDto> getAllEmployees();
	
	EmployeeDto updateEmployee(EmployeeDto employee, Integer id);
	
	void deleteEmployee(Integer id);
		
}
