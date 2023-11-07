package com.example.crud.services.impl;

import java.util.List;
import java.util.stream.Collectors;

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
         Employee employee = employeeRepo.findById(id).orElseThrow();
         return modelMapper.map(employee, EmployeeDto.class);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
        List<Employee> employee = employeeRepo.findAll();
		
		List<EmployeeDto> employeeDtos = employee.stream().map(x->modelMapper.map(x, EmployeeDto.class)).collect(Collectors.toList());
		return employeeDtos;
	}

	@Override
	public EmployeeDto updateEmployee(EmployeeDto employee, Integer id) {
		Employee employee1 = employeeRepo.findById(id).orElseThrow();
		employee1.setFirstName(employee.getFirstName());
		employee1.setLastName(employee.getLastName());
		employee1.setEmail(employee.getEmail());
		employee1.setAge(employee.getAge());
		
		Employee updatedEmployee = employeeRepo.save(employee1);
		return modelMapper.map(updatedEmployee, EmployeeDto.class);
		
	}

	@Override
	public void deleteEmployee(Integer id) {
		Employee employee = employeeRepo.findById(id).orElseThrow();
		employeeRepo.delete(employee);
	}

}
