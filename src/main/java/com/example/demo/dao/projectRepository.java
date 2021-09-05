package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Employee;
import com.example.demo.entities.Project;

public interface projectRepository extends CrudRepository<Project,Long>{

	
	
	@Override
	public List<Project> findAll();
}
