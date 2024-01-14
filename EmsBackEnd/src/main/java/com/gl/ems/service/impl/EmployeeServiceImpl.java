package com.gl.ems.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.ems.entity.Employee;
import com.gl.ems.exception.ResourceNotFoundException;
import com.gl.ems.repository.EmployeeRepository;
import com.gl.ems.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	
	@Autowired
	EmployeeRepository empRepository;

	@Override
	public Employee createEmployee(Employee employee) {
		return empRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(int id) {
		return empRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee with id ="+id+" does not exist"));
		 
	}

	@Override
	public Employee updateEmployeeById(int id, Employee empolyee) {
		Employee e=empRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee with id ="+id+" does not exist"));
		e.setFirstName(empolyee.getFirstName());
		e.setLastName(empolyee.getLastName());
		e.setEmail(empolyee.getEmail());
		empRepository.save(e);
		
		return e;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> list = empRepository.findAll();
		return list;
	}

	@Override
	public void deleteEmployeeByID(int id) {
		Employee e=empRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee with id ="+id+" does not exist"));
		empRepository.deleteById(id);
		
	}

	
	
	
}
