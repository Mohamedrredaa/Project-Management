package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dao.employeeRepository;
import com.example.demo.dao.projectRepository;
import com.example.demo.entities.Employee;
import com.example.demo.entities.Project;

@Controller
@RequestMapping("/Employees")
public class EmployeeController {
	
	
	@Autowired
	employeeRepository empRepo;  //This repository is used to make CRUD opertion through the Project table in db 
	
	
	@RequestMapping("/")
	public String displayProjectForm(Model model) {

		List<Employee> employees =  empRepo.findAll();
		
		
		model.addAttribute("employees" , employees);
		return "employees.html";
		
		
	}
	@RequestMapping("/add")
	public String addNewProject(Model model) {
		model.addAttribute("employee", new Employee());
		return "new-employee.html";
		
	}
	
	
	@PostMapping("/save")
	public String saveNewProject(@ModelAttribute("employee") Employee submittedEmployee) {
		
		System.out.println("Reached here ");
		System.out.println(submittedEmployee.toString());
		empRepo.save(submittedEmployee);
		return "redirect:/Employees/";   //This is to prevent duplicate submissions 
	}
}
