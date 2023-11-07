package com.example.crud.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.payload.EmployeeDto;
import com.example.crud.services.EmployeeService;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/")
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
		EmployeeDto createEmployeeDto = employeeService.createNewEmployee(employeeDto);
		return new ResponseEntity<>(createEmployeeDto, HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<EmployeeDto>> getAllEmployee() {
		return ResponseEntity.ok(this.employeeService.getAllEmployees());
	}
	
	@GetMapping("/{employeeId}")
	public ResponseEntity<EmployeeDto> getSingleUser(@PathVariable Integer employeeId){
		return ResponseEntity.ok(this.employeeService.getEmployeeById(employeeId));
	}
	
	@PutMapping("/{employeeId}")
	public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto, @PathVariable("employeeId") Integer id) {
		EmployeeDto updatedEmployee = employeeService.updateEmployee(employeeDto, id);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	@DeleteMapping("/{employeeId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer employeeId) {
		employeeService.deleteEmployee(employeeId);
		return new ResponseEntity<>("Deleted Succesfull!", HttpStatus.OK);
		
	}
}
