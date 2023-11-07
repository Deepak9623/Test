# Test
Tools used:
* Java
* Spring Boot
* MySql Database

Endpoints for Api:

* To create a new employee:
Post http://localhost:8080/employee/
Body {
    "firstName":"",
    "lastName":"",
    "email":"",
    "age":

}

* To get all employees:
Get http://localhost:8080/employee/

* To get employee by Id:
Get http://localhost:8080/employee/{employeeId}

* To delete employee by Id:
Delete http://localhost:8080/employee/{employeeId}

* To update employee by Id:
Put http://localhost:8080/employee/{employeeId}
Body {
    "firstName":"",
    "lastName":"",
    "email":"",
    "age":

}



