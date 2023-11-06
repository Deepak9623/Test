package com.example.crud.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.crud.entity.Employee;
import com.example.crud.payload.EmployeeDto;
import com.example.crud.repository.EmployeeRepo;
import com.example.crud.services.EmployeeService;

@Service
public class EmplyeeServiceImpl implements EmployeeService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private EmployeeRepo employeeRepo; 

	@Override
	public EmployeeDto createNewEmployee(EmployeeDto employee) {
		Employee employee1 = modelMapper.map(employee, Employee.class);
		Employee savedEmployee = employeeRepo.save(employee1);
		
		return modelMapper.map(savedEmployee, EmployeeDto.class);
	}

	@Override
	public EmployeeDto getEmployeeById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeDto updateEmployee(EmployeeDto employee, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEmployee(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
