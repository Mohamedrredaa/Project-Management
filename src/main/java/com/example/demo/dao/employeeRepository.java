package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Employee;
import com.example.demo.entities.Project;

public interface employeeRepository extends CrudRepository<Employee,Long>{

	
	@Override
	public List<Employee> findAll();

}
