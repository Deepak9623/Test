package com.example.crud.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeDto {

    private int id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private int age;
}
