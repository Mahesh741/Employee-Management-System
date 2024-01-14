package com.gl.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.ems.entity.Employee;
import com.gl.ems.service.impl.EmployeeServiceImpl;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
 @Autowired
 EmployeeServiceImpl empService;
 
 @PostMapping
 ResponseEntity<Employee> createEmployee(@RequestBody Employee employee)
 {
	 Employee e =empService.createEmployee(employee);
	 return new ResponseEntity(e,HttpStatus.CREATED);
 }
 
 @GetMapping
 ResponseEntity<List<Employee>> getAllEmployeeById()
 {
	 List<Employee> e=empService.getAllEmployees();
	 return new ResponseEntity(e,HttpStatus.OK);
 }
 
 @GetMapping("{id}")
 ResponseEntity<Employee> getEmployeeById(@PathVariable int id)
 {
	 Employee e=empService.getEmployeeById(id);
	 return new ResponseEntity(e,HttpStatus.OK);
 }
 
 @PutMapping("{id}")
 ResponseEntity<Employee> updateEmployeeById(@PathVariable int id,@RequestBody Employee employee)
 {
	 Employee e =empService.updateEmployeeById(id, employee);
	 return new ResponseEntity(e,HttpStatus.OK);
 }
 
 @DeleteMapping("{id}")
 ResponseEntity<Employee> deleteEmployeeById(@PathVariable int id)
 {
	 empService.deleteEmployeeByID(id);
	 return new ResponseEntity("Employee deleted successfully ",HttpStatus.OK);
 }
}
