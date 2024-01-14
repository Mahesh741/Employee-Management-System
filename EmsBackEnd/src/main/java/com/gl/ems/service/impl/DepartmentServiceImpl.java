package com.gl.ems.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.gl.ems.entity.Department;
import com.gl.ems.exception.ResourceNotFoundException;
import com.gl.ems.repository.DepartmentRepository;
import com.gl.ems.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	DepartmentRepository depRepository;
	
	
	@Override
	public Department createDepartment(Department department) {
		depRepository.save(department);
		return department;
	}

	@Override
	public Department getDepartmentById(int id) {
		Department d=null;
			d=depRepository.findById(id).orElseThrow((() -> new ResourceNotFoundException("Department is not exists with a given id: " + id)));
		
		return d;
	}

	@Override
	public Department updateDepartmentById(int id, Department department) {
		Department d=null;
		d=depRepository.findById(id).orElseThrow((() -> new ResourceNotFoundException("Department is not exists with a given id: " + id)));
		d.setDepartmentName(department.getDepartmentName());
		d.setDepartmentDescription(department.getDepartmentDescription());
		return depRepository.save(d);
		
	}

	@Override
	public List<Department> getAllDepartments() {
		List<Department> list= depRepository.findAll();
		return list;
	}

	@Override
	public void deleteDepartmentById(int id) {
		Department d=null;
		d=depRepository.findById(id).orElseThrow((() -> new ResourceNotFoundException("Department is not exists with a given id: " + id)));
		
		depRepository.deleteById(id);
		
	}

	

}
